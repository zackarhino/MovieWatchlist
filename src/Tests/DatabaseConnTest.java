package Tests;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnTest {

    // Before letting the user exit the Settings Page,
    // Use this class to make sure the info they entered is valid

    private String host;
    private String dbName;
    public String username;
    private String password;

    public DatabaseConnTest(String host, String dbName, String username, String password) {
        this.host = host;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }

    public boolean testConnection(){
        String url = "jdbc:mysql://" + host + "/" + dbName + "?useSSL=false";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
