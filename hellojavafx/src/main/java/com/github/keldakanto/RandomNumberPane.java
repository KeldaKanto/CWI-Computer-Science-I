package com.github.keldakanto;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class RandomNumberPane extends VBox {
    private Text number;
    private Button generateButton;
    
    public RandomNumberPane() {
        number = new Text("Click the button to generate a random number");
        generateButton = new Button("Generate Random Number");
        generateButton.setOnAction(this::processButtonAction);

        HBox buttonBox = new HBox(generateButton);
        buttonBox.setAlignment(Pos.CENTER);

        setSpacing(20); // between the text and the button
        getChildren().addAll(number, buttonBox);
    }

    public void processButtonAction(ActionEvent event) {
        int randomNum = (int)(Math.random() * 100) + 1; // Random number between 1 and 100
        number.setText("Generated Random Number: " + randomNum);
    }
}