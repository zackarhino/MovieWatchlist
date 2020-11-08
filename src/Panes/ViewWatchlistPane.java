package Panes;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        selectStatus.getSelectionModel().selectFirst();
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


        scrollPane.setContent(movieContainer);
        watchlistWrapper.getChildren().addAll(header, selectStatusContainer, statusTxtContainer, scrollPane);

        selectStatus.setOnAction(actionEvent -> statusTxt.setText(selectStatus.getValue()));

        this.setCenter(pane);
    }
}
