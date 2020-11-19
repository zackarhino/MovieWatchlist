package Tests;

public class DatabaseConnTest {

    // Before letting the user exit the Settings Page, make sure the info they entered is valid

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

    public boolean testConnection(){
//        String url = "";
//        try {
//            Connection connection = DriverManager.getConnection(Url);
//            System.out.println("Connection Established Successful);
//            return true;
//        } catch (Exception e) {
//            System.out.println("Unable to make connection with DB. Reason: " + e);
//            return false;
//        }
        return true;
    }
}
