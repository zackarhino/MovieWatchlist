package Database;

import Util.Constants;

import java.sql.*;

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
            populateTables();
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
        }
    }

    /**
     * Populate the genres and production company tables with values.
     * (Called when the tables are created)
     * @author Trevor Slobodnick
    * */
    private void populateTables(){
        try {
            connection.createStatement().execute(Constants.POPULATE_GENRES);
            connection.createStatement().execute(Constants.POPULATE_PRODUCTION_COMPANY);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
