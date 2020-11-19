package Scenes;

import Panes.FormPane;
import Util.Constants;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class FormScene extends Scene {
    private static FormScene formScene;

    public FormScene() {
        super(new FormPane(), Constants.screenWidth, Constants.screenHeight);
    }

    // Singleton Design Pattern
    public static FormScene getInstance(){
        if(formScene == null){
            formScene = new FormScene();
        }
        return formScene;
    }
}
