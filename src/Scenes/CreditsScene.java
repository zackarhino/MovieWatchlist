package Scenes;

import Panes.CreditsPane;
import Util.Constants;
import javafx.scene.Scene;

public class CreditsScene extends Scene {
    private static CreditsScene creditsScene;

    public CreditsScene() {
        super(new CreditsPane(), Constants.screenWidth, Constants.screenHeight);
    }

    // Singleton Design Pattern
    public static CreditsScene getInstance(){
        if(creditsScene == null){
            creditsScene = new CreditsScene();
        }
        return creditsScene;
    }
}
