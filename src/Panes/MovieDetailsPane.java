package Panes;

import Util.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MovieDetailsPane extends BorderPane {
    public MovieDetailsPane(){
        BorderPane pane = new BorderPane();

        //Entire Screen
        VBox screenWrapper = new VBox();
        //Top Bar
        HBox topSection = new HBox();
        Region region1 = new Region();
        Button closeBtn = new Button("X");
        //Content
        HBox lrWrapper = new HBox();
        //Left side
        VBox leftSideContainer = new VBox();
        Text titleTxt = new Text("Movie Title");
        HBox movieTitle = new HBox(titleTxt);
        Text genreText = new Text("Genre");
        HBox movieGenre = new HBox(genreText);
        HBox additionalInfo = new HBox();
        Text yearTxt = new Text("Year");
        HBox movieYear = new HBox(yearTxt);
        Region filler2 = new Region();
        Text prodCompTxt = new Text("Production Company");
        HBox movieProdCompany = new HBox(prodCompTxt);
        //Right side
        VBox rightSideContainer = new VBox();
        HBox removeBtnContainer = new HBox();
        Button removeMovieBtn = new Button("Remove From Watchlist");

        //PUTTING IT ALL TOGETHER...
        //Top Section
        topSection.getChildren().addAll(closeBtn);
        //Left Side
        additionalInfo.getChildren().addAll(movieYear, filler2, movieProdCompany);
        leftSideContainer.getChildren().addAll(movieTitle, movieGenre, additionalInfo);
        //Right Side
        removeBtnContainer.getChildren().add(removeMovieBtn);
        rightSideContainer.getChildren().addAll(removeBtnContainer);
        //Wrap Left and Right Sides
        lrWrapper.getChildren().addAll(leftSideContainer, rightSideContainer);
        //Adding final containers to screen
        screenWrapper.getChildren().addAll(topSection, lrWrapper);


        //LAYOUT...
        //Alignment
        topSection.setAlignment(Pos.CENTER_RIGHT);
        movieTitle.setAlignment(Pos.TOP_CENTER);
        movieGenre.setAlignment(Pos.CENTER);
        additionalInfo.setAlignment(Pos.BOTTOM_CENTER);
        movieYear.setAlignment(Pos.BOTTOM_LEFT);
        movieProdCompany.setAlignment(Pos.BOTTOM_RIGHT);
        removeBtnContainer.setAlignment(Pos.BOTTOM_CENTER);

        //Margin & Padding
        HBox.setMargin(removeMovieBtn, new Insets(0, 0, 5, 0));
        HBox.setMargin(movieYear, new Insets(0, 0, 5, 5));
        HBox.setMargin(movieProdCompany, new Insets(0, 5, 5, 0));
        movieGenre.setPadding(new Insets(0, Constants.screenWidth * 0.2, 0, Constants.screenWidth * 0.2));
        removeMovieBtn.setPadding(new Insets(25));

        //Vgrow/Hgrow
        /*  Assigning Vgrow/Hgrow to a container allows it to fill all available space,
            similar to flex: 1 in css, which is why some individual nodes are wrapped in HBoxes */
        VBox.setVgrow(lrWrapper, Priority.ALWAYS);
        VBox.setVgrow(movieTitle, Priority.ALWAYS);
        VBox.setVgrow(movieGenre, Priority.ALWAYS);
        VBox.setVgrow(additionalInfo, Priority.ALWAYS);
        VBox.setVgrow(removeBtnContainer, Priority.ALWAYS);
        HBox.setHgrow(leftSideContainer, Priority.ALWAYS);
        HBox.setHgrow(rightSideContainer, Priority.ALWAYS);
        HBox.setHgrow(filler2, Priority.ALWAYS);

        //Colors
        topSection.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, null, null)));
        lrWrapper.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, null, null)));
        rightSideContainer.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, null, null)));

        pane.setCenter(screenWrapper);

        this.setCenter(pane);
    }
}
