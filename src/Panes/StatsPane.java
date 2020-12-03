package Panes;


import Launch.Main;
import Movie.Movie;
import Scenes.MenuScene;
import Tables.MovieTable;
import Util.Constants;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class StatsPane extends BorderPane {
    private PieChart chart;

    public StatsPane(){
        Button backButton = new Button("< Back");
        backButton.setOnAction(actionEvent -> Main.switchScene(MenuScene.getInstance()));
        this.setBackground(new Background(new BackgroundFill(Constants.COLOR_BACKGROUND, null, null)));
        this.setBottom(backButton);

        chart = new PieChart();
        chart.setTitle("Watched Movies");
        chart.setLabelsVisible(true);
        pieChart();
        this.setCenter(chart);
    }

    public void pieChart(){
        //Access to database
        MovieTable movieTable = new MovieTable();
        //Grab list of movies
        ArrayList<Movie> movies = movieTable.getAllMovies();
        //Clear data in chart
        chart.getData().clear();
        //Build list of pieChart data
        ArrayList<PieChart.Data> data = new ArrayList<>();
        for(Movie movie : movies){
            //dont add record unless there is more than 1 movie
            if(movieTable.getMovieCount(movie.getId()) > 0){
                data.add(new PieChart.Data(movie.getTitle(),
                        movieTable.getMovieCount(movie.getId())));
            }
        }
        //Wrapping
        ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList(data);
        //Populate
        chart.setData(chartData);
    }
}
