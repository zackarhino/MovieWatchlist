package Launch;

import Scenes.MovieDetailsScene;
import Util.Constants;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
    public static Stage mainStage;

    @Override
    public void start(Stage stage) {
        mainStage = stage;
        mainStage.setScene(new MovieDetailsScene());
        mainStage.setTitle(Constants.title);
        mainStage.show();
    }
}
