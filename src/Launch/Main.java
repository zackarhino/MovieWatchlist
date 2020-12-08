package Launch;

import Database.DB_CRED;
import Database.Database;
import Panes.ViewWatchlistPane;
import Scenes.MenuScene;
import Scenes.SettingsScene;
import Scenes.ViewWatchlistScene;
import Util.ConfigFileManager;
import Util.Constants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The Main class to launch the application from
 * @author Trevor Slobodnick, Zachary Allard, Jenny Hoang
 */
public class Main extends Application {
    public static Stage mainStage;

    @Override
    public void start(Stage stage) {
        mainStage = stage;

        // Check if config is set
        if (!DB_CRED.isSet()){
            mainStage.setScene(SettingsScene.getInstance(true));
        }else{
            ArrayList<String> dbInfo = ConfigFileManager.readFromFile();
            DB_CRED.setAll(dbInfo.get(0), dbInfo.get(1), dbInfo.get(2), dbInfo.get(3));
            try{
                Database db = Database.getInstance();
                db.setConnection(DB_CRED.getDbHost(), DB_CRED.getDbName(), DB_CRED.getDbUser(), DB_CRED.getDbPass());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            mainStage.setScene(MenuScene.getInstance());
        }
      
        mainStage.setTitle(Constants.title);
        mainStage.setResizable(false);
        mainStage.show();
    }

    /**
     * Swap to a scene. If the scene is the watchlist, update the local Movies and then update the watchlist VBoxes for said Movies
     * @auther Zachary Allard
     * @param scene
     */
    public static void switchScene(Scene scene){
        if(scene instanceof ViewWatchlistScene){
            if(Database.getInstance().testConnection()){
                Database.getInstance().updateMovies();
                ViewWatchlistPane.updateData();
            }
        }
        mainStage.setScene(scene);
        mainStage.show();
    }
}
