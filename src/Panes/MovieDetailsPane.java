package Panes;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MovieDetailsPane extends BorderPane {
    public MovieDetailsPane(){
        BorderPane pane = new BorderPane();

        //Entire Screen
        VBox screenWrapper = new VBox();
        //Top Section
        HBox topSection = new HBox();
        HBox watchedWrapper = new HBox();
        Text watchedText = new Text("Watched");
        CheckBox watchedCheckbox = new CheckBox();
        Button closeBtn = new Button("X");
        //Rest of Screen
        HBox lrWrapper = new HBox();
        //Left side
        VBox leftSideContainer = new VBox();
        Text movieTitle = new Text("Movie Title");
        Text movieGenre = new Text("Genre");
        HBox additionalInfo = new HBox();
        Text movieYear = new Text("Year");
        Text movieProdCompany = new Text("Production Company");
        //Right side
        VBox rightSideContainer = new VBox();
        HBox ratingContainer = new HBox();
        Image star1 = new Image("Images/small_star.png");
        ImageView rating1 = new ImageView(star1);
        Image star2 = new Image("Images/small_star.png");
        ImageView rating2 = new ImageView(star2);
        Image star3 = new Image("Images/small_star.png");
        ImageView rating3 = new ImageView(star3);
        Image star4 = new Image("Images/small_star.png");
        ImageView rating4 = new ImageView(star4);
        Image star5 = new Image("Images/small_star.png");
        ImageView rating5 = new ImageView(star5);
        Button removeMovieBtn = new Button("Remove From Watchlist");

        //Putting It All Together...
        //Top Section
        watchedWrapper.getChildren().addAll(watchedText, watchedCheckbox);
        topSection.getChildren().addAll(watchedWrapper, closeBtn);
        //Left Side
        additionalInfo.getChildren().addAll(movieYear, movieProdCompany);
        leftSideContainer.getChildren().addAll(movieTitle, movieGenre, additionalInfo);
        //Right Side
        ratingContainer.getChildren().addAll(rating1, rating2, rating3, rating4, rating5);
        rightSideContainer.getChildren().addAll(ratingContainer, removeMovieBtn);
        //Wrap Left and Right Sides
        lrWrapper.getChildren().addAll(leftSideContainer, rightSideContainer);
        //Adding final containers to screen
        screenWrapper.getChildren().addAll(topSection, lrWrapper);

        pane.setCenter(screenWrapper);

        this.setCenter(pane);
    }
}
