import Scenes.FormScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Watchlist extends Application {
    //Create a public static stage
    public static Stage mainStage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //populate the mainStage with the primaryStage
        mainStage = primaryStage;
        //only use the mainStage
        mainStage.setScene(new FormScene());
        mainStage.setTitle("Watchlist");
        mainStage.show();
    }
}
