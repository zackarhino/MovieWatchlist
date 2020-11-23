package Panes;

import Database.MySqlVars;
import Launch.Main;
import Scenes.MenuScene;
import Tests.DatabaseConnTest;
import Util.ConfigFileManager;
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

        HBox bottomButtons = new HBox();
        Button connectButton = new Button("Connect");
        Button returnToMenu = new Button("Return to Menu");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(dbHost, dbUser, dbName, dbPassword);

        if (!isFirstTime){
            bottomButtons.getChildren().addAll(connectButton, returnToMenu);
        }
        else{
            bottomButtons.getChildren().addAll(connectButton);
        }

        this.setCenter(hBox);
        this.setBottom(bottomButtons);

        connectButton.setOnAction(e->{
            DatabaseConnTest dbTest = new DatabaseConnTest(dbHost.getText(), dbName.getText(), dbUser.getText(), dbPassword.getText());
            boolean connection = dbTest.testConnection();
            if (connection){
                MySqlVars.setAll(dbHost.getText(), dbName.getText(), dbUser.getText(), dbPassword.getText());
                ConfigFileManager.writeToFile(dbHost.getText(), dbName.getText(), dbUser.getText(), dbPassword.getText());
            }
            else{
              //alert the user and let them retry
            }
        });

        returnToMenu.setOnAction(e -> Main.switchScene(MenuScene.getInstance()));
    }
}
