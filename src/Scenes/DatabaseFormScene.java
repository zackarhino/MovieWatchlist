package Scenes;

import Panes.DatabaseFormPane;
import Util.Constants;
import javafx.scene.Scene;

public class DatabaseFormScene extends Scene {
    private static DatabaseFormScene databaseFormScene;

    private DatabaseFormScene() {
        super(new DatabaseFormPane(), Constants.screenWidth, Constants.screenHeight);
    }

    // Singleton Design Pattern
    public static DatabaseFormScene getInstance(){
        if(databaseFormScene == null){
            databaseFormScene = new DatabaseFormScene();
        }
        return databaseFormScene;
    }
}
