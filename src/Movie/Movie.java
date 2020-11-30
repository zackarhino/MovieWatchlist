package Movie;

import java.util.ArrayList;

public class Movie {

    private static ArrayList<Movie> totalMovies = new ArrayList<>();

    public static ArrayList<Movie> getTotalMovies() {
        return totalMovies;
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
        totalMovies.add(this);
    }

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
