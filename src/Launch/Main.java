package Launch;

import Scenes.MenuScene;
import Scenes.MovieDetailsScene;
import Scenes.ViewWatchlistScene;
import Util.Constants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage mainStage;

    @Override
    public void start(Stage stage) {
        mainStage = stage;
        mainStage.setScene(MenuScene.getInstance());
        mainStage.setTitle(Constants.title);
        mainStage.show();
    }

    // Swap to a new scene
    public static void switchScene(Scene scene){
        mainStage.setScene(scene);
        mainStage.show();
    }
}
