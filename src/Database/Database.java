package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
