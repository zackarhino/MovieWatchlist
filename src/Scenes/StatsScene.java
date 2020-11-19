package Scenes;

import Panes.StatsPane;
import Util.Constants;
import javafx.scene.Scene;

public class StatsScene extends Scene {
    private static StatsScene statsScene;

    public StatsScene() {
        super(new StatsPane(), Constants.screenWidth, Constants.screenHeight);
    }

    // Singleton Design Pattern
    public static StatsScene getInstance(){
        if(statsScene == null){
            statsScene = new StatsScene();
        }
        return statsScene;
    }
}
