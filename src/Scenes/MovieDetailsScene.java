package Scenes;

import Panes.MovieDetailsPane;
import Util.Constants;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MovieDetailsScene extends Scene {
    public MovieDetailsScene() {
        super(new MovieDetailsPane(), Constants.screenWidth, Constants.screenHeight);
    }
}
