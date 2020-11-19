package Panes;


import Launch.Main;
import Scenes.MenuScene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class StatsPane extends BorderPane {
    public StatsPane(){
        Button backButton = new Button("< Back");
        backButton.setOnAction(actionEvent -> Main.switchScene(MenuScene.getInstance()));
        this.setCenter(backButton);
    }
}
