package Panes;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class DatabaseFormPane extends BorderPane {

    public DatabaseFormPane() throws IOException{
        TextField dbHost = new TextField();
        TextField dbUser = new TextField();
        TextField dbName = new TextField();
        TextField dbPassword = new TextField();

        dbHost.setPromptText("Enter DB Host");
        dbUser.setPromptText("Enter DB User");
        dbName.setPromptText("Enter DB Name");
        dbPassword.setPromptText("Enter DB Password");

        BufferedWriter out = new BufferedWriter(new FileWriter("DBinfo.txt"));

        Button connectButton = new Button("Connect");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(dbHost, dbUser, dbName, dbPassword);

        this.setCenter(hBox);
        this.setBottom(connectButton);

        connectButton.setOnAction(e->{
            try {
                out.write(dbHost.getText() + " ");
                out.write(dbUser.getText() + " ");
                out.write(dbName.getText() + " ");
                out.write(dbPassword.getText() + " ");
                //Make sure all content in buffer is written
                out.flush();
//                    out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    });
    }
}
