package Panes;

import Database.Database;
import Launch.Main;
import Scenes.ViewWatchlistScene;
import Util.Constants;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
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
        movieName.setPrefWidth(Constants.MENU_BUTTON_WIDTH);
        year.setPrefWidth(Constants.MENU_BUTTON_WIDTH);
        productionCompany.setPrefWidth(Constants.MENU_BUTTON_WIDTH);
        genre.setPrefWidth(Constants.MENU_BUTTON_WIDTH);

        HBox input1 = new HBox();
        input1.getChildren().addAll(new Label("Movie title: "),
                movieName, new Label("Year: "), year);
        input1.setAlignment(Pos.CENTER);
        input1.setSpacing(Constants.DEFAULT_SPACING);

        //Get info from database
        Database db = Database.getInstance();
        ArrayList<String> db_genres = db.getAllGenres();
        ArrayList<String> db_prodCompany = db.getAllProdCompanies();

        //genres
        genre.setItems(FXCollections.observableArrayList(db_genres));

        //production companies
        productionCompany.setItems(FXCollections.observableArrayList(db_prodCompany));

        HBox input2 = new HBox();
        input2.getChildren().addAll(new Label("Production Company: "), productionCompany,
                new Label("Genre: "), genre);
        input2.setAlignment(Pos.CENTER);
        input2.setSpacing(Constants.DEFAULT_SPACING);

        VBox inputs = new VBox();
        inputs.getChildren().addAll(input1, input2);
        inputs.setSpacing(Constants.DEFAULT_SPACING);
        inputs.setPrefWidth(Constants.SCREEN_WIDTH);
        inputs.setPadding(new Insets(Constants.DEFAULT_PADDING));

        Button backButton = new Button("< Back");
        Button enterButton = new Button("Enter Movie");

        //back
        backButton.setOnAction(actionEvent -> Main.switchScene(ViewWatchlistScene.getInstance()));

        //enters Movie
        enterButton.setOnAction(event->{
            try {
                int genreAsInt = db_genres.indexOf(genre.getValue().toString());
                int productionCompanyAsInt = db_prodCompany.indexOf(productionCompany.getValue().toString());
                int yearAsInt = 2020;
                yearAsInt = Integer.parseInt(year.getText());

                db.addMovie(movieName.getText(), yearAsInt, genreAsInt, productionCompanyAsInt);
                movieName.clear();
                year.clear();
                System.out.println("Inserted Movie.");

                Main.switchScene(ViewWatchlistScene.getInstance());
            } catch (Exception e){
                System.out.println("Error: Couldn't Insert Movie. Please check to make sure you have entered all required values.");
            }
        });

        // Styling
        this.setBackground(new Background(new BackgroundFill(Constants.COLOR_BACKGROUND, null, null)));

        HBox hbox = new HBox();
        hbox.getChildren().addAll(backButton, enterButton);
        hbox.setSpacing(Constants.DEFAULT_SPACING);
        hbox.setPadding(new Insets(Constants.DEFAULT_PADDING));

        this.setCenter(inputs);
        this.setBottom(hbox);
    }
}
