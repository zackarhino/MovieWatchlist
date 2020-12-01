package Scenes;

import Panes.MenuPane;
import Util.Constants;
import javafx.scene.Scene;

public class MenuScene extends Scene {
    private static MenuScene menuScene;

    private MenuScene() {
        super(new MenuPane(), Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    }

    // Singleton Design Pattern
    public static MenuScene getInstance(){
        if(menuScene == null){
            menuScene = new MenuScene();
        }
        return menuScene;
    }
}
