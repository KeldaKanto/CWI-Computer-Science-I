package com.github.keldakanto;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RandomNumber extends Application {
    public void start(Stage primaryStage) {
        RandomNumberPane pane = new RandomNumberPane();
        pane.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: lightgreen");

        Scene scene = new Scene(pane, 400, 150);

        primaryStage.setTitle("RandomNumber");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void Main(String[] args) {
        launch(args);
    }
}