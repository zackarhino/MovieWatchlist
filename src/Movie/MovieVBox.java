package Movie;

import javafx.scene.layout.VBox;

public class MovieVBox extends VBox {
    private Movie movie;

    public MovieVBox(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }
}
