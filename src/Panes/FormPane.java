package Panes;

import Database.Database;
import Launch.Main;
import Scenes.FormScene;
import Scenes.MenuScene;
import Scenes.ViewWatchlistScene;
import Util.Constants;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;

import java.util.ArrayList;
import static Util.Constants.*;

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

        //Get info from database
        Database db = Database.getInstance();
        ArrayList<String> db_genres = db.getGenres();
        ArrayList<String> db_prodCompany = db.getProdCompany();

        //genres
        genre.setItems(FXCollections.observableArrayList(db_genres));

        //production companies
        productionCompany.setItems(FXCollections.observableArrayList(db_prodCompany));

        HBox input2 = new HBox();
        input2.getChildren().addAll(new Label("Production Company: "), productionCompany,
                new Label("Genre: "), genre);
        input2.setAlignment(Pos.CENTER);

        VBox inputs = new VBox();
        inputs.getChildren().addAll(input1, input2);

        Button backButton = new Button("Back");
        Button enterButton = new Button("Enter Movie");

        //back
        backButton.setOnAction(actionEvent -> Main.switchScene(ViewWatchlistScene.getInstance()));

        //enters Movie
        enterButton.setOnKeyPressed(e->{
            int genreAsInt = db_genres.indexOf(genre.getValue().toString());
            int productionCompanyAsInt = db_prodCompany.indexOf(productionCompany.getValue().toString());
            int yearAsInt = 2020;
            try {
                yearAsInt = Integer.parseInt(year.getText());
            } catch (Exception exception){
                exception.printStackTrace();
            }
            db.addMovie(movieName.getText(), yearAsInt, genreAsInt, productionCompanyAsInt);
            movieName.clear();
            year.clear();
        });

        // Styling
        this.setBackground(new Background(new BackgroundFill(Constants.COLOR_BACKGROUND_COLOR, null, null)));

        HBox hbox = new HBox();
        hbox.getChildren().addAll(backButton, enterButton);
        this.setCenter(inputs);
        this.setBottom(hbox);
    }
}
