package Movie;

import javafx.scene.layout.VBox;

public class MovieVBox extends VBox {
    private int movieId;
    private int indexVal;

    public MovieVBox(int movieId, int indexVal) {
        this.movieId = movieId;
        this.indexVal = indexVal;
    }

    public int getMovieId() {
        return movieId;
    }

    public int getIndexVal() {
        return indexVal;
    }
}
