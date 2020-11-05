package Panes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class FormPane extends BorderPane {
    private TextField movieNameInput = new TextField();

    public FormPane(){
        HBox user = new HBox();
        user.getChildren().addAll(new Label("Enter text here: "), movieNameInput);
        user.setAlignment(Pos.CENTER);

        Button enter = new Button("Enter Movie");

        //enters Movie
        enter.setOnKeyPressed(e->{
                //movieNameInput.getText()
                movieNameInput.clear();
        });

        this.setCenter(user);
        this.setBottom(enter);
    }
}
