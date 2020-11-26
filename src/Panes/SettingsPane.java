package Panes;

import Database.DB_CRED;
import Database.Database;
import Launch.Main;
import Scenes.MenuScene;
import Util.ConfigFileManager;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.sql.SQLException;

public class SettingsPane extends BorderPane {


    public SettingsPane(boolean isFirstTime) {
        TextField dbHost = new TextField("localhost");
        TextField dbName = new TextField();
        TextField dbUser = new TextField();
        PasswordField dbPassword = new PasswordField();

        dbHost.setPromptText("DB Host");
        dbName.setPromptText("DB Name");
        dbUser.setPromptText("DB User");
        dbPassword.setPromptText("DB Password");

        HBox bottomButtons = new HBox();
        Button connectButton = new Button("Connect");
        Button returnToMenu = new Button("Return to Menu");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(dbHost, dbName, dbUser, dbPassword);

        if (!isFirstTime){
            bottomButtons.getChildren().addAll(connectButton, returnToMenu);
        }
        else{
            bottomButtons.getChildren().addAll(connectButton);
        }

        this.setCenter(hBox);
        this.setBottom(bottomButtons);

        // Button Actions
        connectButton.setOnAction(event->{
            Database db = Database.getInstance();

            String host = dbHost.getText();
            String name = dbName.getText();
            String user = dbUser.getText();
            String pass = dbPassword.getText();

            try {
                db.setConnection(host, name, user, pass);

                if(db.testConnection()){
                    System.out.println("Connection established and verified.");
                    DB_CRED.setAll(host, name, user, pass);
                    db.createDefaultTables();
                    Main.switchScene(MenuScene.getInstance());
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Couldn't connect to database.");
            }
        });
        returnToMenu.setOnAction(event -> Main.switchScene(MenuScene.getInstance()));

    }
}
