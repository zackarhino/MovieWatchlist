package Scenes;

import Panes.StatsPane;
import Util.Constants;
import javafx.scene.Scene;

public class StatsScene extends Scene {
    private static StatsScene statsScene;
    private String cssPath = "file:src/CSS/chart.css";

    public StatsScene() {
        super(new StatsPane(), Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.getStylesheets().add(cssPath);
    }

    // Singleton Design Pattern
    public static StatsScene getInstance(){
        if(statsScene == null){
            statsScene = new StatsScene();
        }
        return statsScene;
    }
}
