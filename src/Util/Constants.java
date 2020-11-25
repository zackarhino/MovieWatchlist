package Util;

import java.io.File;

public class Constants {
    public static final int screenWidth = 700;
    public static final int screenHeight = 500;
    public static final String title = "Movie Watchlist";
    public static final String configFilePath = "src/Credentials/config.txt";

    //Movie Table
    public static final String TABLE_MOVIE = "Movie";
    public static final String MOVIE_COLUMN_ID = "id";
    public static final String MOVIE_COLUMN_NAME = "name";
    public static final String MOVIE_COLUMN_PRODUCTION_COMPANY = "production_company";
    public static final String MOVIE_COLUMN_YEAR = "year";
    public static final String MOVIE_COLUMN_GENRE = "genre";

    public static final String CREATE_TABLE_MOVIE =
            "CREATE TABLE " + TABLE_MOVIE + "(" +
                    MOVIE_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    MOVIE_COLUMN_NAME + " VARCHAR(255), " +
                    MOVIE_COLUMN_PRODUCTION_COMPANY + " VARCHAR(255), " +
                    MOVIE_COLUMN_YEAR + " VARCHAR(255), " +
                    MOVIE_COLUMN_GENRE + " VARCHAR(255), " +
                    " PRIMARY KEY(" + MOVIE_COLUMN_ID + ")" +
                    ")";
}
