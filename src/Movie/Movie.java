package Movie;

import java.util.ArrayList;

/**
 * The Movie object used to store Movies from the database locally
 * @author Trevor Slobodnick, Zachary Allard
 */
public class Movie {

    private static ArrayList<Movie> allMovies = new ArrayList<>();

    public static ArrayList<Movie> getAllMovies() {
        return allMovies;
    }

    public static void setAllMovies(ArrayList<Movie> allMovies) {
        Movie.allMovies = allMovies;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getGenreAsInt() {
        return genreAsInt;
    }

    public int getProdCompanyAsInt() {
        return prodCompanyAsInt;
    }

    public String getGenreAsStr() {
        return genreAsStr;
    }

    public String getProdCompanyAsStr() {
        return prodCompanyAsStr;
    }

    private int id;
    private String title;
    private int year;
    private int genreAsInt;
    private int prodCompanyAsInt;
    private String genreAsStr;
    private String prodCompanyAsStr;

    public Movie(int id, String title, int year, int genreAsInt, int prodCompanyAsInt, String genreAsStr, String prodCompanyAsStr) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genreAsInt = genreAsInt;
        this.prodCompanyAsInt = prodCompanyAsInt;
        this.genreAsStr = genreAsStr;
        this.prodCompanyAsStr = prodCompanyAsStr;
    }

    /**
     * Adds a Movie object to allMovies
     * @author Zachary Allard
     * @param movie The movie to add
     */
    public static void addMovie(Movie movie){
        allMovies.add(movie);
    }

    /**
     * toString() method
     * @author Trevor Slobodnick
     * @return String interpretation of Movie
     */
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", genreAsInt=" + genreAsInt +
                ", prodCompanyAsInt=" + prodCompanyAsInt +
                ", genreAsStr='" + genreAsStr + '\'' +
                ", prodCompanyAsStr='" + prodCompanyAsStr + '\'' +
                '}';
    }
}
