package Panes;

import Database.Database;
import Launch.Main;
import Movie.Movie;
import Movie.MovieVBox;
import Scenes.FormScene;
import Scenes.MenuScene;
import Util.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ViewWatchlistPane extends BorderPane {
    public ViewWatchlistPane(){
        Database db = Database.getInstance();

        BorderPane pane = new BorderPane();

        VBox watchlistWrapper = new VBox();
        //Header Row
        HBox header = new HBox();
        //ComboBox Row
        VBox menuContainer = new VBox();
        Button backButton = new Button("< Back");
        Button addListButton = new Button("+ New movie");
        //Display Status Row
        Text statusTxt = new Text("Need to Watch");
        Text titleText = new Text("My Movies");
        HBox statusTxtContainer = new HBox(statusTxt);
        VBox movieContainer = new VBox();
        //Put movie Container inside of scrollpane to handle overflow
        ScrollPane scrollPane = new ScrollPane(movieContainer);

        /*
        * The movieContainer will contain Hboxes
        * These Hboxes will contain 3 "movies" (Subject to change)
        * The "movies" will display the title and year
        * Each "movie" will be clickable
        */

        db.createMovies();
        ArrayList<Movie> movies = Movie.getTotalMovies();
        ArrayList<VBox> movieInfo = new ArrayList<>();
        HBox row = new HBox();
        for (Movie movie: movies) {
            Label title = new Label(movie.getTitle());
            Label year = new Label(String.valueOf(movie.getYear()));
            MovieVBox movieVBox = new MovieVBox(movie.getId(), movies.indexOf(movie));
            movieVBox.getChildren().addAll(title, year);
            movieInfo.add(movieVBox);
        }
        for (int i = 0; i < movieInfo.size(); i++) {
            if (i == movies.size() - 1){
                //Add to hbox and then add to vbox
                row.getChildren().add(movieInfo.get(i));
                movieContainer.getChildren().add(row);
                break;
            }
            if (i % 3 == 0){
                //Add Hbox to view and clear it
                movieContainer.getChildren().add(row);
                row = new HBox();
            }
        }

        //PUTTING IT ALL TOGETHER...
        header.getChildren().add(titleText);
        menuContainer.getChildren().addAll(backButton, addListButton);
        menuContainer.setSpacing(Constants.DEFAULT_SPACING);
        menuContainer.setPadding(new Insets(Constants.DEFAULT_PADDING));
        scrollPane.setContent(movieContainer);
        watchlistWrapper.getChildren().addAll(header, menuContainer, statusTxtContainer, scrollPane);

        //LAYOUT
        //Size
        movieContainer.setMinWidth(700);
        movieContainer.setMinHeight(435);
        backButton.setPrefWidth(Constants.MENU_BUTTON_WIDTH);
        addListButton.setPrefWidth(Constants.MENU_BUTTON_WIDTH);

        //Position
        header.setAlignment(Pos.TOP_CENTER);
        statusTxtContainer.setAlignment(Pos.CENTER);

        //Vgrow/Hgrow
        VBox.setVgrow(scrollPane, Priority.ALWAYS);

        //Styling
        this.setBackground(new Background(new BackgroundFill(Constants.COLOR_ACCENT_DARK, null, null)));
        titleText.setFill(Constants.COLOR_TEXT_ALT);
        titleText.setFont(Constants.FONT_SUBTITLE_FONT);
        statusTxt.setFill(Constants.COLOR_TEXT_ALT);
        movieContainer.setBackground(new Background(new BackgroundFill(Constants.COLOR_BACKGROUND, null, null)));
        scrollPane.setBackground(
                new Background(new BackgroundFill(Constants.COLOR_ACCENT_DARK, null, null))
        ); // Remove the ScrollPane border
        scrollPane.setStyle("-fx-focus-color:transparent;"); // Remove the focus border

        //Scrollbar
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        //SETUP
        backButton.setOnAction(actionEvent -> Main.switchScene(MenuScene.getInstance()));
        addListButton.setOnAction(actionEvent -> {
            if(!db.testConnection()){
                System.out.println("Error: Connection isn't valid. Movies won't be added to your database.");
            }
            Main.switchScene(FormScene.getInstance());
        });

        pane.setCenter(watchlistWrapper);
        this.setCenter(pane);
    }
}
