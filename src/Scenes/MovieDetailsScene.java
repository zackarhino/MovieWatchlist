package Scenes;

import Panes.MovieDetailsPane;
import Panes.ViewWatchlistPane;
import Util.Constants;
import javafx.scene.Scene;

public class MovieDetailsScene extends Scene {
    private static MovieDetailsScene movieDetailsScene;

    public MovieDetailsScene() {
        super(new MovieDetailsPane(), Constants.screenWidth, Constants.screenHeight);
    }

    // Singleton Design Pattern
    public static MovieDetailsScene getInstance(){
        if(movieDetailsScene == null){
            movieDetailsScene = new MovieDetailsScene();
        }
        return movieDetailsScene;
    }
}
