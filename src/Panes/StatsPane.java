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
    int otherCount = 0;
    int actionCount = 0;
    int adventureCount = 0;
    int animationCount = 0;
    int comedyCount = 0;
    int dramaCount = 0;
    int horrorCount = 0;
    int mysteryCount = 0;
    int romanceCount = 0;
    int scienceCount = 0;

    public StatsPane(){
        HBox buttons = new HBox();
        Button backButton = new Button("< Back");
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
        //Grab list of movies
        ArrayList<Movie> movies = Movie.getAllMovies();

        //Build list of pieChart data
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();

        //dont add record unless there is more than 1 movie
        if(!movies.isEmpty()){
            for(Movie movie : movies){
                // TODO: display something else
                String genre = movie.getGenreAsStr();
                genreCount(genre);
//                data.add(new PieChart.Data(genre, movie.getGenreAsInt()));
                System.out.println(actionCount + "\n" +
                        adventureCount + "\n" +
                        animationCount + "\n" +
                        comedyCount + "\n" +
                        dramaCount + "\n" +
                        horrorCount + "\n" +
                        mysteryCount + "\n" +
                        romanceCount + "\n" +
                        scienceCount + "\n" +
                        otherCount + "\n"

                        );
            }
            data.add(new PieChart.Data("Action", actionCount));
            data.add(new PieChart.Data("Adventure", adventureCount));
            data.add(new PieChart.Data("Animation", animationCount));
            data.add(new PieChart.Data("Comedy", comedyCount));
            data.add(new PieChart.Data("Drama", dramaCount));
            data.add(new PieChart.Data("Horror", horrorCount));
            data.add(new PieChart.Data("Mystery", mysteryCount));
            data.add(new PieChart.Data("Romance", romanceCount));
            data.add(new PieChart.Data("Science Fiction", scienceCount));
            data.add(new PieChart.Data("Other", otherCount));

        }

        PieChart chart = new PieChart(data);

        //Populate
        chart.setTitle("Watched Movies");
        chart.setLabelsVisible(true);
        chart.setLegendVisible(false);
        return chart;
    }

    private void genreCount(String genre){
        switch (genre){
            case "Action":
                actionCount += 1;
                break;
            case "Adventure":
                adventureCount += 1;
                break;
            case "Animation":
                animationCount += 1;
                break;
            case "Comedy":
                comedyCount += 1;
                break;
            case "Drama":
                dramaCount += 1;
                break;
            case "Horror":
                horrorCount += 1;
                break;
            case "Mystery":
                mysteryCount += 1;
                break;
            case "Romance":
                romanceCount += 1;
                break;
            case "Science Fiction":
                scienceCount += 1;
                break;
            default:
                otherCount += 1;
                break;
        }










    }
}
