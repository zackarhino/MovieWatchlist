package Tests;

public class DatabaseConnTest {

    // Before letting the user exit the Settings Page,
    // Use this class to make sure the info they entered is valid

    private String host;
    private String dbName;
    private String username;
    private String password;

    public DatabaseConnTest(String host, String dbName, String username, String password) {
        this.host = host;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }

//    public boolean testConnection(){
//        String url = "jdbc:mysql://" + host + ":3306/" + dbName;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection(url, username, password);
//            System.out.println("Connection Established Successful);
//            return true;
//        } catch (Exception e) {
//            System.out.println("Unable to make connection with DB. Reason: " + e);
//            return false;
//        }
//    }
}
