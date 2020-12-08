package Util;

import Database.DB_CRED;

import java.io.*;
import java.util.ArrayList;


/**
 * Class that handles reading and writing to the config.txt file (database credentials)
 * @author Trevor Slobodnick
 * */
public class ConfigFileManager {
    private static File configFile = new File(Constants.configFilePath);

    /**
     * Writes the given parameters into config.txt
     * @param dbHost The name of the host
     * @param dbName The name of the database
     * @param dbUser The username for the database
     * @param dbPass The password for the database
     * @author Trevor Slobodnick
     * */
    public static void writeToFile(String dbHost, String dbName, String dbUser, String dbPass){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(configFile, false));
            bw.write(dbHost);
            bw.newLine();
            bw.write(dbName);
            bw.newLine();
            bw.write(dbUser);
            bw.newLine();
            bw.write(dbPass);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads database info, stored in config.txt, into an arraylist
     * @author Trevor Slobodnick
     * @return ArrayList<String>
     * */
    public static ArrayList<String> readFromFile(){
        ArrayList<String> dbInfo = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(configFile));
            String line;
            while ((line = br.readLine()) != null) {
                dbInfo.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dbInfo;
    }
}
