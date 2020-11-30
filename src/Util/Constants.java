package Util;

public class Constants {
    // APPLICATION CONSTANTS
    public static final int screenWidth = 700;
    public static final int screenHeight = 500;

    public static final String title = "Movie Watchlist";
    public static final String configFilePath = "src/Credentials/config.txt";

    public static final int DEFAULT_BUTTON_SPACING = 10;

    // SQL COLUMN NAMES
    //WatchList Table
    public static final String TABLE_WATCHLIST = "watchlist";
    public static final String WATCHLIST_COLUMN_ID = "id";
    public static final String WATCHLIST_COLUMN_TITLE = "title";
    public static final String WATCHLIST_COLUMN_YEAR = "year";
    public static final String WATCHLIST_COLUMN_GENRE = "genre";
    public static final String WATCHLIST_COLUMN_PRODUCTION_COMPANY = "production_company";

    //Production Companies Table
    public static final String TABLE_PRODUCTION_COMPANIES = "production_companies";
    public static final String PD_COLUMN_ID = "id";
    public static final String PD_COLUMN_NAME = "name";

    //Genres Table
    public static final String TABLE_GENRES = "genres";
    public static final String GENRE_COLUMN_ID = "id";
    public static final String GENRE_COLUMN_NAME = "name";

    // SQL QUERIES
    // Create table statements
    public static final String CREATE_TABLE_PRODUCTION_COMPANIES =
            "CREATE TABLE " + TABLE_PRODUCTION_COMPANIES + "(" +
                    PD_COLUMN_ID + " int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    PD_COLUMN_NAME + " VARCHAR(255) NOT NULL" +
                    ")";
    public static final String CREATE_TABLE_GENRES =
            "CREATE TABLE " + TABLE_GENRES + "(" +
                    GENRE_COLUMN_ID + " int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    GENRE_COLUMN_NAME + " VARCHAR(255) NOT NULL" +
                    ")";
    public static final String CREATE_TABLE_WATCHLIST =
            "CREATE TABLE " + TABLE_WATCHLIST + " (" +
                    WATCHLIST_COLUMN_ID + " int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    WATCHLIST_COLUMN_TITLE + " VARCHAR(255) NOT NULL, " +
                    WATCHLIST_COLUMN_YEAR + " int(11) NOT NULL DEFAULT 2020, " +
                    WATCHLIST_COLUMN_GENRE + " int(11) NOT NULL DEFAULT 1, " +
                    WATCHLIST_COLUMN_PRODUCTION_COMPANY + " int(11) NOT NULL DEFAULT 1, " +
                    "FOREIGN KEY(" + WATCHLIST_COLUMN_GENRE + ") REFERENCES " + TABLE_GENRES + "(" + GENRE_COLUMN_ID + "), " +
                    "FOREIGN KEY(" + WATCHLIST_COLUMN_PRODUCTION_COMPANY + ") REFERENCES " + TABLE_PRODUCTION_COMPANIES + "(" + PD_COLUMN_ID + ")" +
            ")";

    //Insert Statements
    public static final String POPULATE_PRODUCTION_COMPANY =
            "INSERT INTO " + TABLE_PRODUCTION_COMPANIES +
                    "(" + PD_COLUMN_ID + ", " + PD_COLUMN_NAME + ")" + " VALUES " +
                    "(" + 1 + ", 'Other')," +
                    "(" + 2 + ", 'Dreamworks Pictures')," +
                    "(" + 3 + ", 'Lionsgate Films')," +
                    "(" + 4 + ", 'Paramount Pictures')," +
                    "(" + 5 + ", 'Sony Pictures')," +
                    "(" + 6 + ", 'The Weinstein Company')," +
                    "(" + 7 + ", 'Universal Studios')," +
                    "(" + 8 + ", 'Walt Disney Studios')," +
                    "(" + 9 + ", 'Warner Bros')," +
                    "(" + 10 + ", '20th Century Fox');";

    public static final String POPULATE_GENRES =
            "INSERT INTO " + TABLE_GENRES +
                    "(" + GENRE_COLUMN_ID + ", " + GENRE_COLUMN_NAME + ")" + " VALUES " +
                    "(" + 1 + ", 'Other')," +
                    "(" + 2 + ", 'Action')," +
                    "(" + 3 + ", 'Adventure')," +
                    "(" + 4 + ", 'Animation')," +
                    "(" + 5 + ", 'Comedy')," +
                    "(" + 6 + ", 'Drama')," +
                    "(" + 7 + ", 'Horror')," +
                    "(" + 8 + ", 'Mystery')," +
                    "(" + 9 + ", 'Romance')," +
                    "(" + 10 + ", 'Science Fiction');";

    // CRUD Queries
    public static final String VIEW_TABLE_WATCHLIST =
            "SELECT * FROM " + TABLE_WATCHLIST;

    public static final String VIEW_TABLE_GENRES =
            "SELECT * FROM " + TABLE_GENRES;

    public static final String VIEW_TABLE_PRODUCTION_COMPANIES =
            "SELECT * FROM " + TABLE_PRODUCTION_COMPANIES;

    public static final String DELETE_FROM_WATCHLIST =
            "DELETE FROM " + TABLE_WATCHLIST + " WHERE " + WATCHLIST_COLUMN_ID + " = id";
}
