package Panes;

import Database.Database;
import Launch.Main;
import Scenes.FormScene;
import Scenes.MenuScene;
import Util.Constants;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ViewWatchlistPane extends BorderPane {
    public ViewWatchlistPane(){
        Database db = Database.getInstance();
        db.createMovies();

        BorderPane pane = new BorderPane();

        VBox watchlistWrapper = new VBox();
        //Header Row
        HBox header = new HBox(new Text("My Movies"));
        //ComboBox Row
        VBox menuContainer = new VBox();
        Button backButton = new Button("< Back");
        Button addListButton = new Button("+ New movie");
        //Display Status Row
        Text statusTxt = new Text("Need to Watch");
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

        //PUTTING IT ALL TOGETHER...
        menuContainer.getChildren().addAll(backButton, addListButton);
        menuContainer.setSpacing(Constants.DEFAULT_BUTTON_SPACING);
        scrollPane.setContent(movieContainer);
        watchlistWrapper.getChildren().addAll(header, menuContainer, statusTxtContainer, scrollPane);

        //LAYOUT
        //Size
        movieContainer.setMinWidth(700);
        movieContainer.setMinHeight(435);

        //Position
        header.setAlignment(Pos.TOP_CENTER);
        statusTxtContainer.setAlignment(Pos.CENTER);

        //Vgrow/Hgrow
        VBox.setVgrow(scrollPane, Priority.ALWAYS);

        //Color
        movieContainer.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, null, null)));

        //Scrollbar
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        //SETUP
        backButton.setOnAction(actionEvent -> Main.switchScene(MenuScene.getInstance()));
        addListButton.setOnAction(actionEvent -> Main.switchScene(FormScene.getInstance()));

        pane.setCenter(watchlistWrapper);
        this.setCenter(pane);
    }
}
