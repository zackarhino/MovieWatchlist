package Panes;

import Launch.Main;
import Scenes.MenuScene;
import Util.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CreditsPane extends BorderPane {
    public CreditsPane(){
        Button backButton = new Button("< Back");
        backButton.setOnAction(actionEvent -> Main.switchScene(MenuScene.getInstance()));

        Label label_appName = new Label("MOVIE WATCHLIST");
        Label label_watchlistWarriors_header = new Label("\nCreated by:");
        Label label_watchlistWarriors = new Label("Created by The Watchlist Warriors!");
        Label label_codeCredits_header = new Label("\nCode authored by:");
        Label label_codeCredits = new Label("Zachary Allard, Trevor Slobodnick, and Jenny Hoang");
        Label label_artCredits_header = new Label("\nArt assets created by:");
        Label label_artCredits = new Label("Zachary Allard");

        // Adding nodes
        VBox creditLabels = new VBox();
        creditLabels.getChildren().addAll(label_appName, label_watchlistWarriors_header, label_watchlistWarriors, label_codeCredits_header, label_codeCredits, label_artCredits_header, label_artCredits);
        creditLabels.setAlignment(Pos.CENTER);

        VBox buttons = new VBox();
        buttons.getChildren().addAll(backButton);

        // Styling
        this.setBackground(new Background(new BackgroundFill(Constants.COLOR_BACKGROUND, null, null)));

        label_appName.setTextFill(Constants.COLOR_ACCENT);
        label_appName.setFont(Constants.FONT_MENU_TITLE_FONT);
        label_watchlistWarriors_header.setFont(Constants.FONT_SUBTITLE_FONT);
        label_watchlistWarriors.setFont(Constants.FONT_SUBTITLE_FONT);
        label_codeCredits_header.setFont(Constants.FONT_SUBTITLE_FONT);
        label_codeCredits.setFont(Constants.FONT_SUBTITLE_FONT);
        label_artCredits_header.setFont(Constants.FONT_SUBTITLE_FONT);
        label_artCredits.setFont(Constants.FONT_SUBTITLE_FONT);

        buttons.setPadding(new Insets(Constants.DEFAULT_PADDING));

        this.setCenter(creditLabels);
        this.setBottom(buttons);
    }
}
