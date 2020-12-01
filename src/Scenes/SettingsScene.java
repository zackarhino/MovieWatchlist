package Scenes;

import Panes.SettingsPane;
import Util.Constants;
import javafx.scene.Scene;

public class SettingsScene extends Scene {

    private static SettingsScene settingsScene;

    private SettingsScene(boolean isFirstTime) {
        super(new SettingsPane(isFirstTime), Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    }

    /**
     * @param isFirstTime Determines if it's the users first time using the application.
     *                    Set to true only in {@link Launch.Main}, otherwise it should be false
     * */
    public static SettingsScene getInstance(boolean isFirstTime){
        if(settingsScene == null){
            settingsScene = new SettingsScene(isFirstTime);
        }
        return settingsScene;
    }
}
