package Panes;


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

    public StatsPane(){
        HBox buttons = new HBox();
        Button backButton = new Button("< Back");
        buttons.getChildren().addAll(backButton);
        buttons.setPadding(new Insets(Constants.DEFAULT_PADDING));
        backButton.setOnAction(actionEvent -> Main.switchScene(MenuScene.getInstance()));

        chart = new PieChart();
        chart.setTitle("Genres Watched");
        chart.setLabelsVisible(true);
        pieChart();
        this.setCenter(chart);
    }

    /**
     * Create a new PieChart and return it
     * @return PieChart of local data
     * @author Jenny Hoang
     */
    private PieChart createPieChart(){
        //Grab list of movies
        ArrayList<Movie> movies = Movie.getAllMovies();

        //Build list of pieChart data
        ArrayList<PieChart.Data> data = new ArrayList<>();
        for(Movie movie : movies){
            //dont add record unless there is more than 1 movie

            if(movieTable.getMovieCount(movie.getId()) > 0){
                data.add(new PieChart.Data(movie.getGenreAsStr(),
                        movieTable.getMovieCount(movie.getGenreAsInt())));
            }
        }

        PieChart chart = new PieChart(data);

        //Populate
        chart.setTitle("Watched Movies");
        chart.setLabelsVisible(true);
        chart.setLegendVisible(false);
        return chart;
    }
}
