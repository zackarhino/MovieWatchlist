package Movie;

import java.util.ArrayList;

/**
 * The Movie object used to store Movies from the database locally
 * @author Trevor Slobodnick, Zachary Allard
 */
public class Movie {

    private static ArrayList<Movie> allMovies = new ArrayList<>();

    private int id;
    private String title;
    private int year;
    private int genreAsInt;
    private int prodCompanyAsInt;
    private String genreAsStr;
    private String prodCompanyAsStr;

    /**
     * @param id id of movie in watchlist table
     * @param title title of the movie
     * @param year year the movie was released
     * @param genreAsInt id of the genre in the genres table
     * @param prodCompanyAsInt id of production company in the production_companies table
     * @param genreAsStr genre of the film
     * @param prodCompanyAsStr production company of the film
     * */
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
     * Get allMovies
     * @return ArrayList<Movie>
     * */
    public static ArrayList<Movie> getAllMovies() {
        return allMovies;
    }

    /**
     * Set allMovies
     * */
    public static void setAllMovies(ArrayList<Movie> allMovies) {
        Movie.allMovies = allMovies;
    }

    /**
     * Get Movie id
     * @return int
     * */
    public int getId() {
        return id;
    }

    /**
     * Get Movie title
     * @return String
     * */
    public String getTitle() {
        return title;
    }

    /**
     * Get Movie year
     * @return int
     * */
    public int getYear() {
        return year;
    }

    /**
     * Get Movie genre corresponding id in genres table
     * @return int
     * */
    public int getGenreAsInt() {
        return genreAsInt;
    }

    /**
     * Get Movie production company corresponding id in production_companies table
     * @return int
     * */
    public int getProdCompanyAsInt() {
        return prodCompanyAsInt;
    }

    /**
     * Get Movie genre
     * @return String
     * */
    public String getGenreAsStr() {
        return genreAsStr;
    }

    /**
     * Get Movie production company
     * @return String
     * */
    public String getProdCompanyAsStr() {
        return prodCompanyAsStr;
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
