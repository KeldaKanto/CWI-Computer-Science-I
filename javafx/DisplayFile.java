package com.github.keldakanto;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DisplayFile extends Application {
    public void start(Stage primaryStage) throws IOException {
        FileChooser chooser = new FileChooser();
        File selectedFile = chooser.showOpenDialog(primaryStage);

        TextArea content = new TextArea();
        content.setFont(new Font("Courier", 12));
        content.setEditable(false);

        if (selectedFile == null) {
            content.setText("No file chosen.");
        } else {
            Scanner scanInput = new Scanner(selectedFile);

            String info = "";
            while (scanInput.hasNext())
                info += scanInput.nextLine() + "\n";

            content.setText(info);
            scanInput.close();
        }

        Scene scene = new Scene(content, 500, 500);

        primaryStage.setTitle("Display File");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}