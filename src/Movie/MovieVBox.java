package Movie;

import javafx.scene.layout.VBox;

/**
 * Custom Vbox that stores movie objects
 * @author Trevor Slobodnick
 * */
public class MovieVBox extends VBox {
    private Movie movie;

    /**
     * Create a VBox that stores a movie object
     * @param movie The movie to add to this VBox
     * */
    public MovieVBox(Movie movie) {
        this.movie = movie;
    }

    /**
     * Gets movie object associated with vbox
     * @return Movie
     * */
    public Movie getMovie() {
        return movie;
    }
}
