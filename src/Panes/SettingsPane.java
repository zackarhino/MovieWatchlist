package Panes;

import Tests.DatabaseConnTest;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class SettingsPane extends BorderPane {
    public SettingsPane(boolean isFirstTime){
        BorderPane pane = new BorderPane();

        Button returnHome = new Button("Return Home");
        Button firstTime = new Button("First Time");



        if (!isFirstTime){
            pane.setCenter(returnHome);
        }
        else{
            pane.setCenter(firstTime);
        }




//      Once the submit button is clicked, do the following:
//        DatabaseConnTest dbTest = new DatabaseConnTest("localhost", "dbName", "username", "password");
//        boolean connection = dbTest.testConnection();
//        if (connection){
//          //write to file...
//        }
//        else{
//          //alert the user and let them retry
//        }

        this.setCenter(pane);
    }
}
