package Database;

import java.util.ArrayList;

public class MySqlVars {
    private static String DB_HOST;
    private static String DB_NAME;
    private static String DB_USER;
    private static String DB_PASS;

    public static String getDbHost() {
        return DB_HOST;
    }

    public static String getDbName() {
        return DB_NAME;
    }

    public static String getDbUser() {
        return DB_USER;
    }

    public static String getDbPass() {
        return DB_PASS;
    }

    public static void setAll(String dbHost, String dbName, String dbUserName, String dbPassword){
        DB_HOST = dbHost;
        DB_NAME = dbName;
        DB_USER = dbUserName;
        DB_PASS = dbPassword;
    }
}
