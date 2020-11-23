package Database;

public class MySqlVars {
    private static String DB_NAME;
    private static String DB_USER;
    private static String DB_PASS;

    public static void setAll(String dbName, String dbUserName, String dbPassword){
        DB_NAME = dbName;
        DB_USER = dbUserName;
        DB_PASS = dbPassword;
    }
}
