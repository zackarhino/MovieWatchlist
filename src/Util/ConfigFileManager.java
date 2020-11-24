package Util;

import Database.DB_CRED;

import java.io.*;
import java.util.ArrayList;

public class ConfigFileManager {
    private static File configFile = new File(Util.Constants.configFilePath);

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
            // Set variables so we don't have to read from file everytime
            DB_CRED.setAll(dbHost, dbName, dbUser, dbPass);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
