package Scenes;

import Panes.MovieDetailsPane;
import Util.Constants;
import javafx.scene.Scene;

public class MovieDetailsScene extends Scene {
    private static MovieDetailsScene movieDetailsScene;

    public MovieDetailsScene() {
        super(new MovieDetailsPane(), Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    }

    // Singleton Design Pattern
    public static MovieDetailsScene getInstance(){
        if(movieDetailsScene == null){
            movieDetailsScene = new MovieDetailsScene();
        }
        return movieDetailsScene;
    }
}
