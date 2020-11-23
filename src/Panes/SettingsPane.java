package Panes;

import Tests.DatabaseConnTest;
import Util.Constants;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SettingsPane extends BorderPane {


    public SettingsPane(boolean isFirstTime) {
        TextField dbHost = new TextField();
        TextField dbUser = new TextField();
        TextField dbName = new TextField();
        TextField dbPassword = new TextField();

        dbHost.setPromptText("Enter DB Host");
        dbUser.setPromptText("Enter DB User");
        dbName.setPromptText("Enter DB Name");
        dbPassword.setPromptText("Enter DB Password");

        Button connectButton = new Button("Connect");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(dbHost, dbUser, dbName, dbPassword);

        this.setCenter(hBox);
        this.setBottom(connectButton);

//        if (!isFirstTime){
//            // Add return home button
//        }
//        else{
//            // No return home button
//        }

        connectButton.setOnAction(e->{
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(new File(Constants.configFilePath)));
                out.write(dbHost.getText() + " ");
                out.write(dbUser.getText() + " ");
                out.write(dbName.getText() + " ");
                out.write(dbPassword.getText() + " ");
                //Make sure all content in buffer is written
                out.flush();
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            // call test (see below)
        });



//      TEST
//      Once the submit button is clicked, do the following:
//        DatabaseConnTest dbTest = new DatabaseConnTest("localhost", "dbName", "username", "password");
//        boolean connection = dbTest.testConnection();
//        if (connection){
//          //write to file...
//        }
//        else{
//          //alert the user and let them retry
//        }
    }
}
