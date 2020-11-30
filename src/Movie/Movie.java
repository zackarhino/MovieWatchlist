package Movie;

import java.util.ArrayList;

public class Movie {

    private static ArrayList<Movie> allMovies;

    private String title;
    private int year;
    private int genreAsInt;
    private int prodCompanyAsInt;
    private String genreAsStr;
    private String prodCompanyAsStr;

    public Movie(String title, int year, int genreAsInt, int prodCompanyAsInt, String genreAsStr, String prodCompanyAsStr) {
        this.title = title;
        this.year = year;
        this.genreAsInt = genreAsInt;
        this.prodCompanyAsInt = prodCompanyAsInt;
        this.genreAsStr = genreAsStr;
        this.prodCompanyAsStr = prodCompanyAsStr;
        allMovies.add(this);
    }
}
