package Panes;

import Launch.Main;
import Scenes.MenuScene;
import Util.Constants;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;

public class CreditsPane extends BorderPane {
    public CreditsPane(){
        Button backButton = new Button("< Back");
        backButton.setOnAction(actionEvent -> Main.switchScene(MenuScene.getInstance()));

        // Styling
        this.setBackground(new Background(new BackgroundFill(Constants.COLOR_BACKGROUND_COLOR, null, null)));

        this.setCenter(backButton);
    }
}
