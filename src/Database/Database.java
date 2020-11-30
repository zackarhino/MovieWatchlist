package Database;

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
        String query =
                "INSERT INTO " + TABLE_WATCHLIST + "(" + WATCHLIST_COLUMN_TITLE + ", " +
                        WATCHLIST_COLUMN_YEAR + ", " +
                        WATCHLIST_COLUMN_GENRE + ", " +
                        WATCHLIST_COLUMN_PRODUCTION_COMPANY + ")\n" +
                        "VALUES (" + title + ", " +
                        year + ", " +
                        genre + ", " +
                        prodCompany + ");";
        try {
            connection.createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<String> getGenres(){
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

    public ArrayList<String> getProdCompany(){
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
}
