package Scenes;

import Panes.SettingsPane;
import Util.Constants;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SettingsScene extends Scene {
    private static SettingsScene settingsScene;
    private SettingsScene(boolean isFirstTime) {
        super(new SettingsPane(isFirstTime), Constants.screenWidth, Constants.screenHeight);
    }

    // Singleton Design Pattern
    public static SettingsScene getInstance(boolean isFirstTime){
        if(settingsScene == null){
            settingsScene = new SettingsScene(isFirstTime);
        }
        return settingsScene;
    }
}
