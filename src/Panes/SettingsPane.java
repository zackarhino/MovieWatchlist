package Panes;

import Database.DB_CRED;
import Database.Database;
import Launch.Main;
import Scenes.MenuScene;
import Util.Constants;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

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
        Button returnToMenu = new Button("< Back");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(dbHost, dbName, dbUser, dbPassword);
        hBox.setSpacing(Constants.DEFAULT_SPACING);

        bottomButtons.setSpacing(Constants.DEFAULT_SPACING);
        if (!isFirstTime){
            bottomButtons.getChildren().addAll(returnToMenu, connectButton);
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

        // Styling
        this.setBackground(new Background(new BackgroundFill(Constants.COLOR_BACKGROUND_COLOR, null, null)));
    }
}
