package Panes;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ViewWatchlistPane extends BorderPane {
    public ViewWatchlistPane(){
        BorderPane pane = new BorderPane();

        ArrayList<String> status = new ArrayList<>();
        status.add("Need to Watch");
        status.add("Watched");

        VBox watchlistWrapper = new VBox();
        HBox title = new HBox(new Text("My Movies"));
        HBox selectStatusContainer = new HBox();
        ComboBox<String> selectStatus = new ComboBox<>(FXCollections.observableArrayList(status));
        selectStatus.getSelectionModel().selectFirst();
        Text statusTxt = new Text();
        HBox statusTxtContainer = new HBox(statusTxt);

        selectStatus.setOnAction(actionEvent -> statusTxt.setText(selectStatus.getValue()));

        this.setCenter(pane);
    }
}
