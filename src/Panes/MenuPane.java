package Panes;

import Launch.Main;
import Scenes.*;
import Util.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MenuPane extends BorderPane {
    public MenuPane(){
        StackPane stackPane = new StackPane();

        BorderPane root = new BorderPane();
        BorderPane curtainOverlay = new BorderPane();

        ImageView logoImageView = new ImageView();
        Text headlineText = new Text("MOVIE WATCHLIST");
        Font headlineFont = Constants.FONT_MENU_TITLE_FONT;

        ImageView leftCurtainImageView = new ImageView();
        ImageView rightCurtainImageView = new ImageView();

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
        leftCurtainImageView.setImage(new Image("Images/curtain_left.png"));
        leftCurtainImageView.setPreserveRatio(true);
        leftCurtainImageView.setFitHeight(Constants.SCREEN_HEIGHT);
        rightCurtainImageView.setImage(new Image("Images/curtain_right.png"));
        rightCurtainImageView.setPreserveRatio(true);
        rightCurtainImageView.setFitHeight(Constants.SCREEN_HEIGHT);
        watchlistButton.setOnAction(actionEvent -> Main.switchScene(ViewWatchlistScene.getInstance()));
        statsButton.setOnAction(actionEvent -> Main.switchScene(StatsScene.getInstance()));
        creditsButton.setOnAction(actionEvent -> Main.switchScene(CreditsScene.getInstance()));
        loginButton.setOnAction(actionEvent -> Main.switchScene(SettingsScene.getInstance(false)));

        // Styling
        headlineText.setFont(headlineFont);
        headlineText.setFill(Constants.COLOR_ACCENT);
        root.setBackground(new Background(new BackgroundFill(Constants.COLOR_BACKGROUND, null, null)));

        // Spacing
        // MAGIC NUMBERS 🙌
        double panePaddingSize = Constants.SCREEN_WIDTH * 0.135;
        double paneInnerSize = Constants.SCREEN_HEIGHT - (panePaddingSize*2);
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
        submenuButtons.setSpacing(Constants.DEFAULT_SPACING);
        buttonWrapper.setSpacing(buttonSpacing);
        buttonWrapper.setPadding(new Insets(0, buttonWrapperPadding, 0, buttonWrapperPadding));

        menuWrapper.setPrefWidth(paneInnerSize/2);
        menuWrapper.setPrefHeight(paneInnerSize/2);
        menuWrapper.setPrefWidth(paneInnerSize/2);
        menuWrapper.setPrefHeight(paneInnerSize/2);

        // Maybe not the best implementation, but will stop at the max width of the buttonWrapper
        watchlistButton.setPrefWidth(Constants.SCREEN_WIDTH);
        statsButton.setPrefWidth(Constants.SCREEN_WIDTH);
        loginButton.setPrefWidth(Constants.SCREEN_WIDTH);
        creditsButton.setPrefWidth(Constants.SCREEN_WIDTH);

        root.setPadding(new Insets(panePaddingSize, panePaddingSize, panePaddingSize, panePaddingSize));

        // Adding Everything...Everything!
        buttonWrapper.getChildren().addAll(watchlistButton, statsButton, submenuButtons);
        headerWrapper.getChildren().addAll(logoImageView, buttonWrapper);
        menuWrapper.getChildren().addAll(headerWrapper, headlineText);
        menuWrapper.setAlignment(Pos.CENTER);

        curtainOverlay.setLeft(leftCurtainImageView);
        curtainOverlay.setRight(rightCurtainImageView);

        curtainOverlay.setMaxWidth(Constants.SCREEN_WIDTH);
        curtainOverlay.setMaxHeight(Constants.SCREEN_HEIGHT);

        stackPane.getChildren().addAll(root, curtainOverlay);
        curtainOverlay.setPickOnBounds(false);

        root.setCenter(menuWrapper);
        this.setCenter(stackPane);
    }

}
