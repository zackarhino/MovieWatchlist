package Database;

import Movie.Movie;
import Util.Constants;

import java.sql.*;
import java.util.ArrayList;

import static Util.Constants.*;

public class Database {

    private static Database database = null;
    private Connection connection = null;

    /**
     * Private Constructor
     */
    private Database() {

    }

    /**
     * Take database credentials and use them to connect to database
     * * TODO: Collect these from the form-
     * @return connection The connection if valid, null if invalid
     * @param host The host server
     * @param database The database name
     * @param user Username
     * @param password Password
     */
    public Connection setConnection(String host, String database, String user, String password) throws SQLException{
        disconnect();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://" + host + "/"+ database + "?serverTimezone=UTC", user, password);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error: Connection not established.");
        }
        return connection;
    }

    /**
     * Terminates the connection
     */
    public void disconnect(){
        if(this.connection!=null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        this.connection = null;
    }

    /**
     * Checks to see if the connection is set and open
     * @return bool True if open and connected, false if not connected or unset
     */
    public boolean testConnection(){
        if(connection != null){
            try {
                if(connection.isValid(15)){
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Returns the database instance
     * @return Database
     */
    public static Database getInstance() {
        if(database == null){
            database = new Database();
        }
        return database;
    }

    /**
     * Add all of the default watchlist tables to the database
     * @author Zachary Allard
     */
    public void createDefaultTables(){
        try {
            createTable(Constants.TABLE_PRODUCTION_COMPANIES, Constants.CREATE_TABLE_PRODUCTION_COMPANIES, connection);
            createTable(Constants.TABLE_GENRES, Constants.CREATE_TABLE_GENRES, connection);
            createTable(Constants.TABLE_WATCHLIST, Constants.CREATE_TABLE_WATCHLIST, connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Creates a table in the database
     * Note: must be called after DB_CRED variables are set
     * @author ?
     * @param tableName The table name in SQL
     * @param tableQuery The Query to execute
     * @param connection The database's connection
     * @throws SQLException
     */
    public void createTable(String tableName, String tableQuery, Connection connection) throws SQLException{
        Statement createTables;
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(DB_CRED.getDbName(), null, tableName, null);
        if(resultSet.next()){
            System.out.println(tableName + " Table already exists!");
        } else {
            createTables = connection.createStatement();
            createTables.execute(tableQuery);
            System.out.println("The " + tableName + " table has been inserted.");
            if (tableName.equals(Constants.TABLE_GENRES)){
                connection.createStatement().execute(Constants.POPULATE_GENRES);
            }
            else if (tableName.equals(Constants.TABLE_PRODUCTION_COMPANIES)){
                connection.createStatement().execute(Constants.POPULATE_PRODUCTION_COMPANY);
            }
        }
    }

    /**
     * Adds a movie to the database
     * @param title The title of the movie
     * @param year The year the movie was released
     * @param genre The genre of the movie
     * @param prodCompany The company that produced the movie
     * @author Trevor Slobodnick
     * */
    public void addMovie(String title, int year, int genre, int prodCompany){
        //Add 1 because these are index values, so they will always be 1 less than they're db counterparts
        genre += 1;
        prodCompany += 1;
        String query =
                "INSERT INTO " + TABLE_WATCHLIST + "(" + WATCHLIST_COLUMN_TITLE + ", " +
                        WATCHLIST_COLUMN_YEAR + ", " +
                        WATCHLIST_COLUMN_GENRE + ", " +
                        WATCHLIST_COLUMN_PRODUCTION_COMPANY + ")" +
                        " VALUES ('" + title + "', " +
                        year + ", " +
                        genre + ", " +
                        prodCompany + ");";
        try {
            connection.createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Movie Successfully Added");
        }
    }

    /**
     * Get all rows from the database and create movie objects from them
     * @author Trevor Slobodnick
     * */
    public void createMovies(){
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(VIEW_TABLE_WATCHLIST);
            while (rs.next()){
                int id = Integer.parseInt(rs.getString(1));
                String title = rs.getString(2);
                int year = Integer.parseInt(rs.getString(3));
                int genreAsInt = Integer.parseInt(rs.getString(4));
                int prodCompanyAsInt = Integer.parseInt(rs.getString(5));
                Movie movie = new Movie(id,
                        title,
                        year,
                        genreAsInt,
                        prodCompanyAsInt,
                        getGenre(genreAsInt),
                        getProdCompany(prodCompanyAsInt));
                System.out.println(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets all genres from database
     * @author Trevor Slobodnick
     * */
    public ArrayList<String> getAllGenres(){
        ArrayList<String> genres = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Constants.VIEW_TABLE_GENRES);
            while (rs.next()){
                genres.add(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

    /**
     * Gets a specific genre based on id given
     * @param id The id of the genre
     * @author Trevor Slobodnick
     * */
    public String getGenre(int id){
        String query =
                "SELECT " + GENRE_COLUMN_NAME + " FROM " + TABLE_GENRES + " WHERE " + GENRE_COLUMN_ID + " = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            return rs.getString(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "";
    }

    /**
     * Gets all production companies from database
     * @author Trevor Slobodnick
     * */
    public ArrayList<String> getAllProdCompanies(){
        ArrayList<String> prodCompanies = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Constants.VIEW_TABLE_PRODUCTION_COMPANIES);
            while (rs.next()){
                prodCompanies.add(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prodCompanies;
    }

    /**
     * Gets a specific production company based on id given
     * @param id The id of the production company
     * @author Trevor Slobodnick
     * */
    public String getProdCompany(int id){
        String query =
                "SELECT " + PD_COLUMN_NAME + " FROM " + TABLE_PRODUCTION_COMPANIES + " WHERE " + PD_COLUMN_ID + " = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
