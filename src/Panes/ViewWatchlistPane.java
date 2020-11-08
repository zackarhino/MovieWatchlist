package Panes;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ViewWatchlistPane extends BorderPane {
    public ViewWatchlistPane(){
        BorderPane pane = new BorderPane();

        //Whenever status is mentioned, it refers to either "Need to Watch" or "Watched"
        ArrayList<String> status = new ArrayList<>();
        status.add("Need to Watch");
        status.add("Watched");

        VBox watchlistWrapper = new VBox();
        //Header Row
        HBox header = new HBox(new Text("My Movies"));
        //ComboBox Row
        HBox selectStatusContainer = new HBox();
        ComboBox<String> selectStatus = new ComboBox<>(FXCollections.observableArrayList(status));
        //Display Status Row
        Text statusTxt = new Text();
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
        selectStatusContainer.getChildren().add(selectStatus);
        scrollPane.setContent(movieContainer);
        watchlistWrapper.getChildren().addAll(header, selectStatusContainer, statusTxtContainer, scrollPane);

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
        selectStatus.getSelectionModel().selectFirst();
        statusTxt.setText(selectStatus.getValue());
        selectStatus.setOnAction(actionEvent -> statusTxt.setText(selectStatus.getValue()));

        pane.setCenter(watchlistWrapper);
        this.setCenter(pane);
    }
}
