package Scenes;

import Movie.Movie;
import Panes.MovieDetailsPane;
import Util.Constants;
import javafx.scene.Scene;

public class MovieDetailsScene extends Scene {

    public MovieDetailsScene(Movie movie) {
        super(new MovieDetailsPane(movie), Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    }

}
