package Panes;


import Database.Database;
import Launch.Main;
import Movie.Movie;
import Scenes.MenuScene;
import Util.Constants;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

/**
 * Pane for displaying watch stats
 * @author Jenny Hoang, Zachary Allard
 */
public class StatsPane extends BorderPane {
    private PieChart chart;
    int[] genresCount = new int[10];
    String[] genres = {"Action","Adventure","Animation","Comedy","Drama","Horror","Mystery","Romance","Science Fiction","Other"};

    public StatsPane(){
        HBox buttons = new HBox();
        Button backButton = new Button("< Back");
        backButton.setPrefWidth(Constants.MENU_BUTTON_WIDTH);
        buttons.getChildren().addAll(backButton);
        buttons.setPadding(new Insets(Constants.DEFAULT_PADDING));
        backButton.setOnAction(actionEvent -> Main.switchScene(MenuScene.getInstance()));

        this.chart = createPieChart();
        this.chart.setPrefWidth(Constants.SCREEN_WIDTH);

        Group group = new Group(this.chart);

        this.setBackground(new Background(new BackgroundFill(Constants.COLOR_BACKGROUND, null, null)));
        this.setBottom(buttons);
        this.setCenter(group);
    }

    /**
     * Create a new PieChart and return it
     * @return PieChart of local data
     * @author Jenny Hoang
     */
    private PieChart createPieChart(){
        Database.getInstance().updateMovies();
        //Grab list of movies
        ArrayList<Movie> movies = Movie.getAllMovies();

        //Build list of pieChart data
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();

        //dont add record unless there is more than 1 movie
        if(!movies.isEmpty()){
            for(Movie movie : movies){
                String genre = movie.getGenreAsStr();
                numberOfGenres(genre);
            }
            for(int i = 0;i < genresCount.length;i++) {
                if(genresCount[i] > 0){
                    data.add(new PieChart.Data(genres[i], genresCount[i]));
                }
            }
        }

        PieChart chart = new PieChart(data);

        //Populate
        chart.setTitle("Watched Movies");
        chart.setLabelsVisible(true);
        chart.setLegendVisible(false);
        return chart;
    }

    private void numberOfGenres(String genre) {
        switch (genre) {
            case "Action":
                genresCount[0] += 1;
                break;
            case "Adventure":
                genresCount[1] += 1;
                break;
            case "Animation":
                genresCount[2] += 1;
                break;
            case "Comedy":
                genresCount[3] += 1;
                break;
            case "Drama":
                genresCount[4] += 1;
                break;
            case "Horror":
                genresCount[5] += 1;
                break;
            case "Mystery":
                genresCount[6] += 1;
                break;
            case "Romance":
                genresCount[7] += 1;
                break;
            case "Science Fiction":
                genresCount[8] += 1;
                break;
            default:
                genresCount[9] += 1;
                break;
        }
    }
}
