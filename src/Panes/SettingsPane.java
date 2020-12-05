package Panes;

import Database.DB_CRED;
import Database.Database;
import Launch.Main;
import Scenes.MenuScene;
import Util.ConfigFileManager;
import Util.Constants;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class SettingsPane extends BorderPane {


    public SettingsPane(boolean isFirstTime) {
        Database db = Database.getInstance();

        TextField dbHost = new TextField("localhost");
        TextField dbName = new TextField();
        TextField dbUser = new TextField();
        PasswordField dbPassword = new PasswordField();

        dbHost.setPromptText("DB Host");
        dbName.setPromptText("DB Name");
        dbUser.setPromptText("DB User");
        dbPassword.setPromptText("DB Password");

        HBox buttons = new HBox();
        Button returnToMenu = new Button("< Back");
        Button connectButton = new Button("Connect");
        Button createTablesButton = new Button("Create Tables");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(dbHost, dbName, dbUser, dbPassword);
        hBox.setSpacing(Constants.DEFAULT_SPACING);
        hBox.setPadding(new Insets(Constants.DEFAULT_PADDING));

        returnToMenu.setPrefWidth(Constants.MENU_BUTTON_WIDTH);
        connectButton.setPrefWidth(Constants.MENU_BUTTON_WIDTH);
        createTablesButton.setPrefWidth(Constants.MENU_BUTTON_WIDTH);

        buttons.setSpacing(Constants.DEFAULT_SPACING);
        buttons.setPadding(new Insets(Constants.DEFAULT_PADDING));

        // Determining which buttons to show
        if (!isFirstTime){
            buttons.getChildren().addAll(returnToMenu, connectButton, createTablesButton);
        }
        else{
            buttons.getChildren().addAll(connectButton);
        }

        // Setting Text values if available
        if(DB_CRED.isSet()){
            dbHost.setText(DB_CRED.getDbHost());
            dbName.setText(DB_CRED.getDbName());
            dbUser.setText(DB_CRED.getDbUser());
            dbPassword.setText(DB_CRED.getDbPass());
        }

        this.setCenter(hBox);
        this.setBottom(buttons);

        // Button Actions
        connectButton.setOnAction(event->{
            String host = dbHost.getText();
            String name = dbName.getText();
            String user = dbUser.getText();
            String pass = dbPassword.getText();

            try {
                db.setConnection(host, name, user, pass);

                if(db.testConnection()){
                    System.out.println("Connection established and verified.");
                    DB_CRED.setAll(host, name, user, pass);
                    ConfigFileManager.writeToFile(DB_CRED.getDbHost(), DB_CRED.getDbName(), DB_CRED.getDbUser(), DB_CRED.getDbPass());
                    Main.switchScene(MenuScene.getInstance());
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Couldn't connect to database. Double check your credentials.");
            }
        });
        createTablesButton.setOnAction(event -> {
            try {
                if(db.testConnection()){
                    db.createDefaultTables();
                    Main.switchScene(MenuScene.getInstance());
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Couldn't create tables.");
            }
        });
        returnToMenu.setOnAction(event -> Main.switchScene(MenuScene.getInstance()));

        this.setBackground(new Background(new BackgroundFill(Constants.COLOR_BACKGROUND, null, null)));
    }
}
