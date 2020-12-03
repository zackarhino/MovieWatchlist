package Panes;


import Launch.Main;
import Scenes.MenuScene;
import Util.Constants;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;

public class StatsPane extends BorderPane {
    private PieChart chart;

    public StatsPane(){
        Button backButton = new Button("< Back");
        backButton.setOnAction(actionEvent -> Main.switchScene(MenuScene.getInstance()));
        this.setBackground(new Background(new BackgroundFill(Constants.COLOR_BACKGROUND, null, null)));
        this.setCenter(backButton);

        chart = new PieChart();
        chart.setTitle("Watched Movies");
        chart.setLabelsVisible(true);
        pieChart();
        this.setCenter(chart);
    }

    public void pieChart(){
       
    }
}
