package Panes;

import javafx.scene.layout.BorderPane;

public class SettingsPane extends BorderPane {
    public SettingsPane(boolean isFirstTime){
        BorderPane pane = new BorderPane();

//        if (isFirstTime){
//            Don't show "Return to Menu" button
//        }
//        else{
//            Show "Return to Menu button
//        }
        this.setCenter(pane);
    }
}
