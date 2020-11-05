package Panes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FormPane extends BorderPane {
    private TextField movieName = new TextField();
    private TextField year = new TextField();
    private TextField productionCompany = new TextField();
    private TextField genre = new TextField();

    public FormPane(){
        HBox input1 = new HBox();
        input1.getChildren().addAll(new Label("Movie title: "),
                movieName, new Label("Year: "), year);
        input1.setAlignment(Pos.CENTER);

        HBox input2 = new HBox();
        input2.getChildren().addAll(new Label("Production Company"), productionCompany,
                new Label("Genre: "), genre);
        input2.setAlignment(Pos.CENTER);

        VBox inputs = new VBox();
        inputs.getChildren().addAll(input1, input2);


        Button enter = new Button("Enter Movie");

        //enters Movie
        enter.setOnKeyPressed(e->{
                //movieNameInput.getText()
                //year.getText()
                //productionCompany.getText()
                //genre.getText()
                movieName.clear();
                year.clear();
                productionCompany.clear();
                genre.clear();
        });

        this.setCenter(inputs);
        this.setBottom(enter);
    }
}
