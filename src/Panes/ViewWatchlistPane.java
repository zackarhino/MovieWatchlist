package Panes;

import Database.Database;
import Launch.Main;
import Movie.Movie;
import Movie.MovieVBox;
import Scenes.FormScene;
import Scenes.MenuScene;
import Scenes.MovieDetailsScene;
import Util.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ViewWatchlistPane extends BorderPane {
    private static VBox movieContainer;
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
        movieContainer = new VBox();
        //Put movie Container inside of scrollpane to handle overflow
        ScrollPane scrollPane = new ScrollPane(movieContainer);


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
        movieContainer.setPadding(new Insets(
                Constants.DEFAULT_PADDING,
                Constants.DEFAULT_PADDING+Constants.SCROLLBAR_OFFSET,
                Constants.DEFAULT_PADDING,
                Constants.DEFAULT_PADDING));
        backButton.setPrefWidth(Constants.MENU_BUTTON_WIDTH);
        addListButton.setPrefWidth(Constants.MENU_BUTTON_WIDTH);
        statusTxtContainer.setPadding(new Insets(Constants.DEFAULT_PADDING));


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
        );// Remove the ScrollPane border
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

    /**
     * Updates/Refreshing the movieContainer by removing all the items and then adding them back
     * @author Trevor Slobodnick, Zachary Allard
     */
    public static void updateData(){
        // Emptying the data before adding everything back
        if(movieContainer != null){
            movieContainer.getChildren().clear();
        }

        /*
         * The movieContainer will contain Hboxes
         * These Hboxes will contain 3 "movies" (Subject to change)
         * The "movies" will display the title and year
         * Each "movie" will be clickable
         */
        ArrayList<Movie> movies = Movie.getAllMovies();
        ArrayList<VBox> movieInfo = new ArrayList<>();
        //Create the display (VBox) for the movies
        for (Movie movie: movies) {
            Label title = new Label(movie.getTitle());
            title.setTextFill(Constants.COLOR_TEXT_ALT);
            title.setTextOverrun(OverrunStyle.ELLIPSIS);
            title.setPadding(new Insets(Constants.MOVIE_PADDING, 0, 0, 0));
            title.setUnderline(true);
            title.setFont(new Font(15));
            Label year = new Label(String.valueOf(movie.getYear()));
            year.setTextFill(Constants.COLOR_TEXT_ALT);
            year.setPadding(new Insets(0, 0, Constants.MOVIE_PADDING, 0));

            MovieVBox movieVBox = new MovieVBox(movie);
            movieVBox.setSpacing(Constants.MOVIE_MIDDLE_PADDING);
            movieVBox.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(Constants.MOVIE_BORDER_RADIUS), BorderWidths.DEFAULT, new Insets(Constants.MOVIE_PADDING))));
            movieVBox.setBackground(new Background(new BackgroundFill(Constants.COLOR_ACCENT_DARK, new CornerRadii(Constants.MOVIE_BORDER_RADIUS), new Insets(Constants.MOVIE_PADDING))));
            movieVBox.setCursor(Cursor.HAND);
            movieVBox.setOnMouseClicked(mouseEvent -> {
                Main.switchScene(new MovieDetailsScene(movieVBox.getMovie()));
            });
            movieVBox.setPrefWidth((((double)Constants.SCREEN_WIDTH/2) - (Constants.DEFAULT_PADDING*2)) - Constants.SCROLLBAR_OFFSET);
            movieVBox.getChildren().addAll(title, year);
            movieInfo.add(movieVBox);
        }
        //Add movies to HBox (Max of 3), then add to vbox
        HBox row = new HBox();
        HBox.setHgrow(row, Priority.ALWAYS);
        for (int i = 0; i < movieInfo.size(); i++) {
            movieInfo.get(i).setAlignment(Pos.CENTER);
            HBox.setHgrow(movieInfo.get(i), Priority.ALWAYS);
            if (i % Constants.NUM_WATCHLIST_COLUMNS == 0 && i != 0){
                //Add Hbox to view and create new one
                movieContainer.getChildren().add(row);
                row = new HBox();
                row.getChildren().add(movieInfo.get(i));
                if (i == movieInfo.size() - 1){
                    movieContainer.getChildren().add(row);
                }
            }
            else{
                row.getChildren().add(movieInfo.get(i));
                if (i == movieInfo.size() - 1){
                    movieContainer.getChildren().add(row);
                }
            }
        }
    }
}
