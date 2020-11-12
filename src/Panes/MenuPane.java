package Panes;

import Launch.Main;
import Scenes.ViewWatchlistScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.File;

public class MenuPane extends BorderPane {
    public MenuPane(){
        ImageView logoImageView = new ImageView();
        Text headlineText = new Text("MOVIE WATCHLIST");
        Font headlineFont = Font.font("Times New Roman", FontWeight.BOLD, 20);

        Button watchlistButton = new Button("VIEW YOUR WATCHLIST >");
        Button statsButton = new Button("Watch stats");
        Button creditsButton = new Button("view credits");

        logoImageView.setImage(new Image("Images/watchlist.png"));
        headlineText.setFont(headlineFont);

        VBox titleWrapper = new VBox();
        VBox menuWrapper = new VBox();

        logoImageView.setPreserveRatio(true);
        logoImageView.setFitWidth(256);
        logoImageView.setFitHeight(256);
        watchlistButton.setOnAction(actionEvent -> Main.switchScene(ViewWatchlistScene.getInstance()));
        // TODO: Make stats and credits screens
        //statsButton.setOnAction(actionEvent -> Main.switchScene(ViewWatchlistScene.getInstance()));
        //creditsButton.setOnAction(actionEvent -> Main.switchScene(ViewWatchlistScene.getInstance()));

        titleWrapper.getChildren().addAll(logoImageView, headlineText);
        menuWrapper.getChildren().addAll(watchlistButton, statsButton, creditsButton);

        this.setLeft(titleWrapper);
        this.setCenter(menuWrapper);
    }

}
