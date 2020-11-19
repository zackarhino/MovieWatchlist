package Launch;

import Scenes.MenuScene;
import Scenes.MovieDetailsScene;
import Scenes.ViewWatchlistScene;
import Util.Constants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

/**
 * The Main class to launch the application from
 * @author Trevor Slobodnick, Zachary Allard, Jenny Hoang
 */
public class Main extends Application {
    public static Stage mainStage;

    @Override
    public void start(Stage stage) {
        mainStage = stage;
        // TODO: Add a check for if the user has already added database credentials
        mainStage.setScene(MenuScene.getInstance());
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
