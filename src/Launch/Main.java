package Launch;

import Database.Database;
import Scenes.MenuScene;
import Scenes.MovieDetailsScene;
import Scenes.SettingsScene;
import Scenes.ViewWatchlistScene;
import Util.Constants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

import java.io.File;

/**
 * The Main class to launch the application from
 * @author Trevor Slobodnick, Zachary Allard, Jenny Hoang
 */
public class Main extends Application {
    public static Stage mainStage;
    public static File configFile = new File(Constants.configFilePath);

    @Override
    public void start(Stage stage) {
        mainStage = stage;

        // Check if config is set
        System.out.println("Config file size: " + configFile.length() + " bytes");
        if (configFile.length() == 0){
            mainStage.setScene(SettingsScene.getInstance(true));
        }else{
            mainStage.setScene(MenuScene.getInstance());
        }
        mainStage.setTitle(Constants.title);
        mainStage.setResizable(false);
        mainStage.show();
    }

    // Swap to a new scene
    public static void switchScene(Scene scene){
        mainStage.setScene(scene);
        mainStage.show();
    }
}
