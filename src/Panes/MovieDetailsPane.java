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
        HBox watchedWrapper = new HBox();
        Text watchedText = new Text("Watched");
        CheckBox watchedCheckbox = new CheckBox();
        Button close = new Button("X");
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
        Image star1 = new Image("Images/star.png");
        ImageView rating1 = new ImageView(star1);
        Image star2 = new Image("Images/star.png");
        ImageView rating2 = new ImageView(star2);
        Image star3 = new Image("Images/star.png");
        ImageView rating3 = new ImageView(star3);
        Image star4 = new Image("Images/star.png");
        ImageView rating4 = new ImageView(star4);
        Image star5 = new Image("Images/star.png");
        ImageView rating5 = new ImageView(star5);

        this.setCenter(pane);
    }
}
