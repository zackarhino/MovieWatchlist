package Panes;

import Database.DB_CRED;
import Database.Database;
import Launch.Main;
import Scenes.MenuScene;
import Scenes.SettingsScene;
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
    private static SettingsPane settingsPane;


    private static HBox buttons = new HBox();
    private static Button returnToMenu = new Button("< Back");
    private static Button connectButton = new Button("Connect");
    private static Button createTablesButton = new Button("Create Tables");

    TextField dbHost = new TextField("localhost");
    TextField dbName = new TextField();
    TextField dbUser = new TextField();
    PasswordField dbPassword = new PasswordField();

    public SettingsPane(boolean isFirstTime) {
        dbHost.setPromptText("DB Host");
        dbName.setPromptText("DB Name");
        dbUser.setPromptText("DB User");
        dbPassword.setPromptText("DB Password");

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

        // Setting Text values if available
        if(DB_CRED.isSet()){
            dbHost.setText(DB_CRED.getDbHost());
            dbName.setText(DB_CRED.getDbName());
            dbUser.setText(DB_CRED.getDbUser());
            dbPassword.setText(DB_CRED.getDbPass());
        }

        this.setCenter(hBox);
        this.setBottom(buttons);
    }

    /**
     * Determining which buttons to display based on the context that the scene is accessed from
     * This works by removing all the buttons and then re-adding them, similarly to the watchlist
     * @param isFirstTime Whether it's the user's first time seeing the FormPane
     */
    public static void addButtons(boolean isFirstTime){
        Database db = Database.getInstance();

        buttons = new HBox();
        buttons.setSpacing(Constants.DEFAULT_SPACING);
        buttons.setPadding(new Insets(Constants.DEFAULT_PADDING));
        if (!isFirstTime){
            buttons.getChildren().addAll(returnToMenu, connectButton, createTablesButton);
        }
        else{
            buttons.getChildren().addAll(connectButton);
        }
        settingsPane = SettingsPane.getInstance(isFirstTime);

        connectButton.setOnAction(event->{
            String host = settingsPane.dbHost.getText();
            String name = settingsPane.dbName.getText();
            String user = settingsPane.dbUser.getText();
            String pass = settingsPane.dbPassword.getText();

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

        settingsPane.setBackground(new Background(new BackgroundFill(Constants.COLOR_BACKGROUND, null, null)));
        settingsPane.setBottom(buttons);
    }

    /**
     * Get an instance of a SettingsPane
     * This uses singleton design pattern so that the SettingScene can reference it in the super call instead of an anonymous SettingsPane
     * @param isFirstTime
     * @return
     */
    public static SettingsPane getInstance(boolean isFirstTime){
        if(settingsPane == null){
            settingsPane = new SettingsPane(isFirstTime);
        }
        return settingsPane;
    }
}
