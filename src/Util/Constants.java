package Util;

import java.io.File;

public class Constants {
    public static final int screenWidth = 700;
    public static final int screenHeight = 500;
    public static final String title = "Movie Watchlist";
    public static final String configFilePath = "src/Credentials/config.txt";

    //Movie Table
    public static final String TABLE_WATCHLIST = "watchlist";
    public static final String WATCHLIST_COLUMN_ID = "id";
    public static final String WATCHLIST_COLUMN_TITLE = "title";
    public static final String WATCHLIST_COLUMN_YEAR = "year";
    public static final String WATCHLIST_COLUMN_GENRE = "genre";
    public static final String WATCHLIST_COLUMN_PRODUCTION_COMPANY = "production_company";


    public static final String CREATE_TABLE_WATCHLIST =
            "CREATE TABLE " + TABLE_WATCHLIST + "(" +
                    WATCHLIST_COLUMN_ID + " int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    WATCHLIST_COLUMN_TITLE + " VARCHAR(255) NOT NULL, " +
                    WATCHLIST_COLUMN_YEAR + " int(11) NOT NULL DEFAULT 2020, " +
                    WATCHLIST_COLUMN_GENRE + " int(11) NOT NULL DEFAULT 1, " +
                    WATCHLIST_COLUMN_PRODUCTION_COMPANY + " int(11) NOT NULL DEFAULT 1, " +
                    "FOREIGN KEY(" + WATCHLIST_COLUMN_GENRE + ") REFERENCES " + WATCHLIST_COLUMN_GENRE + "(" + WATCHLIST_COLUMN_ID + "), " +
                    "FOREIGN KEY(" + WATCHLIST_COLUMN_PRODUCTION_COMPANY + ") REFERENCES " + WATCHLIST_COLUMN_PRODUCTION_COMPANY + "(" + WATCHLIST_COLUMN_ID + "), " +
                    ")";

    public static final String VIEW_TABLE_WATCHLIST =
            "SELECT * FROM " + TABLE_WATCHLIST;

    public static final String INSERT_INTO_WATCHLIST =
            "INSERT INTO " + TABLE_WATCHLIST + "(" + WATCHLIST_COLUMN_TITLE + ", " +
                                                    WATCHLIST_COLUMN_YEAR + ", " +
                                                    WATCHLIST_COLUMN_GENRE + ", " +
                                                    WATCHLIST_COLUMN_PRODUCTION_COMPANY + ")\n" +
            "VALUES (" + WATCHLIST_COLUMN_TITLE + ", " +
                    WATCHLIST_COLUMN_YEAR + ", " +
                    WATCHLIST_COLUMN_GENRE + ", " +
                    WATCHLIST_COLUMN_PRODUCTION_COMPANY + ")";

    public static final String DELETE_FROM_WATCHLIST =
            "DELETE FROM " + TABLE_WATCHLIST + " WHERE " + WATCHLIST_COLUMN_ID + " = id";


}
