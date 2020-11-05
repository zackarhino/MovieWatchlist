import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Form extends Application{
    private TextField movieNameInput = new TextField();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();

        //Enter Movie name
        HBox user = new HBox();
        user.getChildren().addAll(new Label("Movie Name: "), movieNameInput);
        user.setAlignment(Pos.CENTER);
        movieNameInput.setOnKeyPressed(e->{
            if (e.getCode() == KeyCode.ENTER) {
                //movieNameInput.getText()
                movieNameInput.clear();
            }
        });

        pane.setCenter(user);

        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setTitle("Watchlist");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
