package Scenes;

import Panes.ViewWatchlistPane;
import Util.Constants;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ViewWatchlistScene extends Scene {
    public ViewWatchlistScene() {
        super(new ViewWatchlistPane(), Constants.screenWidth, Constants.screenHeight);
    }
}
