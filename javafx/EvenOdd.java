package com.github.keldakanto;

import java.util.Optional;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class EvenOdd extends Application {
    public void start(Stage primaryStage) throws Exception {
        boolean anothaOne = true; 

        while (anothaOne) {
            TextInputDialog inputDialog = new TextInputDialog();
            inputDialog.setHeaderText(null);
            inputDialog.setTitle(null);
            inputDialog.setContentText("Enter an integer:");
            Optional<String> numString = inputDialog.showAndWait();

            if (numString.isPresent()) {
                int num = Integer.parseInt(numString.get());

                String result = "That number is " + ((num % 2 == 0) ? "even." : "odd.");

                Alert answerDialog = new Alert(AlertType.INFORMATION);
                answerDialog.setHeaderText(null);
                answerDialog.setContentText(result);
                answerDialog.showAndWait();

                Alert confirmDialog = new Alert(AlertType.CONFIRMATION);
                confirmDialog.setHeaderText(null);
                confirmDialog.setContentText("Do another?");
                Optional<ButtonType> another = confirmDialog.showAndWait();

                if (another.get() != ButtonType.OK)
                    anothaOne = false;
            } else {
                anothaOne = false;
            }

        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}