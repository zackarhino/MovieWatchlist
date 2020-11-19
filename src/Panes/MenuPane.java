package Panes;

import Launch.Main;
import Scenes.CreditsScene;
import Scenes.StatsScene;
import Scenes.ViewWatchlistScene;
import Util.Constants;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MenuPane extends BorderPane {
    public MenuPane(){
        ImageView logoImageView = new ImageView();
        Text headlineText = new Text("MOVIE WATCHLIST");
        Font headlineFont = Font.font("MV Boli", FontWeight.BOLD, 60);

        Button watchlistButton = new Button("VIEW YOUR WATCHLIST >");
        Button statsButton = new Button("Watch stats >");
        Button creditsButton = new Button("view credits");
        Button loginButton = new Button("login");

        // Wrappers
        HBox submenuButtons = new HBox();

        VBox menuWrapper = new VBox();
        HBox headerWrapper = new HBox();
        VBox buttonWrapper = new VBox();

        // Functionality
        logoImageView.setPreserveRatio(true);
        logoImageView.setImage(new Image("Images/watchlist.png"));
        watchlistButton.setOnAction(actionEvent -> Main.switchScene(ViewWatchlistScene.getInstance()));
        statsButton.setOnAction(actionEvent -> Main.switchScene(StatsScene.getInstance()));
        creditsButton.setOnAction(actionEvent -> Main.switchScene(CreditsScene.getInstance()));
        // TODO: Connect login screen
        //loginButton.setOnAction(actionEvent -> Main.switchScene(LoginScene.getInstance()));

        // Styling
        this.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, null, null)));
        headlineText.setFont(headlineFont);

        // Spacing
        // MAGIC NUMBERS 🙌
        double panePaddingSize = Constants.screenWidth * 0.1;
        double paneInnerSize = Constants.screenHeight - (panePaddingSize*2);
        double buttonWrapperPadding = 10;
        double bigButtonHeight = 60;
        double smallButtonHeight = 30;
        double buttonSpacing = (paneInnerSize/2)/3 - 5;

        submenuButtons.getChildren().addAll(loginButton, creditsButton);

        logoImageView.setFitWidth(256);
        logoImageView.setFitHeight(256);

        watchlistButton.setPrefHeight(bigButtonHeight);
        statsButton.setPrefHeight(bigButtonHeight);
        loginButton.setPrefHeight(smallButtonHeight);
        creditsButton.setPrefHeight(smallButtonHeight);
        buttonWrapper.setSpacing(buttonSpacing);
        buttonWrapper.setPadding(new Insets(0, buttonWrapperPadding, 0, buttonWrapperPadding));

        menuWrapper.setPrefWidth(paneInnerSize/2);
        menuWrapper.setPrefHeight(paneInnerSize/2);
        menuWrapper.setPrefWidth(paneInnerSize/2);
        menuWrapper.setPrefHeight(paneInnerSize/2);

        // Maybe not the best implementation, but will stop at the max width of the buttonWrapper
        watchlistButton.setPrefWidth(Constants.screenWidth);
        statsButton.setPrefWidth(Constants.screenWidth);
        loginButton.setPrefWidth(Constants.screenWidth);
        creditsButton.setPrefWidth(Constants.screenWidth);

        this.setPadding(new Insets(panePaddingSize, panePaddingSize, panePaddingSize, panePaddingSize));

        // Adding Everything...Everything!
        buttonWrapper.getChildren().addAll(watchlistButton, statsButton, submenuButtons);
        headerWrapper.getChildren().addAll(logoImageView, buttonWrapper);
        menuWrapper.getChildren().addAll(headerWrapper, headlineText);

        this.setCenter(menuWrapper);
    }

}
