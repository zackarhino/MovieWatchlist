package Panes;

import Launch.Main;
import Scenes.FormScene;
import Scenes.MenuScene;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class FormPane extends BorderPane {
    private TextField movieName = new TextField();
    private TextField year = new TextField();
    private ComboBox productionCompany = new ComboBox();
    private ComboBox genre = new ComboBox();

    public FormPane(){
        HBox input1 = new HBox();
        input1.getChildren().addAll(new Label("Movie title: "),
                movieName, new Label("Year: "), year);
        input1.setAlignment(Pos.CENTER);

        //genres
        ArrayList<String> genres = new ArrayList<>();
        genres.add("Action");
        genres.add("Comedy");
        genres.add("Horror");
        genre.setItems(FXCollections.observableArrayList(genres));

        //production companies
        ArrayList<String> productionCompanies = new ArrayList<>();
        productionCompanies.add("Marvel");
        productionCompanies.add("Universal Studios");
        productionCompanies.add("Warner Bros.");
        productionCompany.setItems(FXCollections.observableArrayList(productionCompanies));

        HBox input2 = new HBox();
        input2.getChildren().addAll(new Label("Production Company: "), productionCompany,
                new Label("Genre: "), genre);
        input2.setAlignment(Pos.CENTER);

        VBox inputs = new VBox();
        inputs.getChildren().addAll(input1, input2);

        Button backButton = new Button("Back");
        Button enterButton = new Button("Enter Movie");

        //back
        backButton.setOnAction(actionEvent -> Main.switchScene(MenuScene.getInstance()));

        //enters Movie
        enterButton.setOnKeyPressed(e->{
                //movieNameInput.getText()
                //year.getText()
                //productionCompany.getText()
                //genre.getText()
                movieName.clear();
                year.clear();
        });

        this.setCenter(inputs);
        this.setBottom(enterButton);
    }
}
