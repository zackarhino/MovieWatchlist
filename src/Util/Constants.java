package Util;

import java.io.File;

public class Constants {
    public static final int screenWidth = 700;
    public static final int screenHeight = 500;
    public static final String title = "Movie Watchlist";
    public static final String configFilePath = "src/Credentials/config.txt";

    //Movie Table
    public static final String TABLE_WATCHLIST = "watchlist";
    public static final String MOVIE_COLUMN_ID = "id";
    public static final String MOVIE_COLUMN_TITLE = "title";
    public static final String MOVIE_COLUMN_YEAR = "year";
    public static final String MOVIE_COLUMN_GENRE = "genre";
    public static final String MOVIE_COLUMN_PRODUCTION_COMPANY = "production_company";


    public static final String CREATE_TABLE_WATCHLIST =
            "CREATE TABLE " + TABLE_WATCHLIST + "(" +
                    MOVIE_COLUMN_ID + " int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    MOVIE_COLUMN_TITLE + " VARCHAR(255) NOT NULL, " +
                    MOVIE_COLUMN_YEAR + " int(11) NOT NULL DEFAULT 2020, " +
                    MOVIE_COLUMN_GENRE + " int(11) NOT NULL DEFAULT 1, " +
                    MOVIE_COLUMN_PRODUCTION_COMPANY + " int(11) NOT NULL DEFAULT 1, " +
                    "FOREIGN KEY(" + MOVIE_COLUMN_GENRE + ") REFERENCES " + MOVIE_COLUMN_GENRE + "(" + MOVIE_COLUMN_ID + "), " +
                    "FOREIGN KEY(" + MOVIE_COLUMN_PRODUCTION_COMPANY + ") REFERENCES " + MOVIE_COLUMN_PRODUCTION_COMPANY + "(" + MOVIE_COLUMN_ID + "), " +
                    ")";

    public static final String VIEW_TABLE_WATCHLIST =
            "SELECT * FROM " + TABLE_WATCHLIST;

    public static final String INSERT_INTO_WATCHLIST =
            ""
}
