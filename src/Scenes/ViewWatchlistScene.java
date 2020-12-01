package Scenes;

import Panes.ViewWatchlistPane;
import Util.Constants;
import javafx.scene.Scene;

public class ViewWatchlistScene extends Scene {
    private static ViewWatchlistScene viewWatchlistScene;
    public ViewWatchlistScene() {
        super(new ViewWatchlistPane(), Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    }

    // Singleton Design Pattern
    public static ViewWatchlistScene getInstance(){
        if(viewWatchlistScene == null){
            viewWatchlistScene = new ViewWatchlistScene();
        }
        return viewWatchlistScene;
    }
}
