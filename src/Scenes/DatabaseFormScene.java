package Scenes;

import Panes.DatabaseFormPane;
import Util.Constants;
import javafx.scene.Scene;

import java.io.IOException;

public class DatabaseFormScene extends Scene {
    private static DatabaseFormScene databaseFormScene;

    public DatabaseFormScene() throws IOException {
        super(new DatabaseFormPane(), Constants.screenWidth, Constants.screenHeight);
    }

    // Singleton Design Pattern
    public static DatabaseFormScene getInstance() throws IOException {
        if(databaseFormScene == null){
            databaseFormScene = new DatabaseFormScene();
        }
        return databaseFormScene;
    }
}
