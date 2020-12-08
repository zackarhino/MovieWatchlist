package Database;

import Util.Constants;

import java.io.File;

/**
 * File to store database credentials locally
 * @author Trevor Slobodnick, Jenny Hoang
 */
public class DB_CRED {
    public static File configFile = new File(Constants.configFilePath);

    private static String DB_HOST; // The database host
    private static String DB_NAME; // The database name
    private static String DB_USER; // The database user
    private static String DB_PASS; // The database password

    /**
     * Gets DB_HOST
     * @return String
     * */
    public static String getDbHost() {
        return DB_HOST;
    }

    /**
     * Gets DB_NAME
     * @return String
     * */
    public static String getDbName() {
        return DB_NAME;
    }

    /**
     * Gets DB_USER
     * @return String
     * */
    public static String getDbUser() {
        return DB_USER;
    }

    /**
     * Gets DB_PASS
     * @return String
     * */
    public static String getDbPass() {
        return DB_PASS;
    }

    /**
     * Sets all DB_CREDs at once
     * @author Trevor Slobodnick, Jenny Hoang
     * @param dbHost Hostname
     * @param dbName Database name
     * @param dbUserName User name
     * @param dbPassword Password
     */
    public static void setAll(String dbHost, String dbName, String dbUserName, String dbPassword){
        DB_HOST = dbHost;
        DB_NAME = dbName;
        DB_USER = dbUserName;
        DB_PASS = dbPassword;
    }

    /**
     * Returns true if there is data in the config file, otherwise returns false.
     * WARNING: Doesn't check that the data is valid, only that there is data.
     * @author Zachary Allard
     * @return True if contains data, false if not
     */
    public static boolean isSet(){
        return configFile.length() > 0;
    }
}
