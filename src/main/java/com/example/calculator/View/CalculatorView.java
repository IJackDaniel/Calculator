package com.example.calculator.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CalculatorView extends Application{

    @Override
    public void start(Stage stage) {
        // Create elements of control
        TextField display = new TextField();
        display.setEditable(false);
        // Bind for ViewModel

        Label errorLabel = new Label();
        // Bind for ViewModel
        errorLabel.setStyle("-fx-text-fill: red;");

        // Add buttons
        GridPane buttonsGrid = new GridPane();
        buttonsGrid.setHgap(5);
        buttonsGrid.setVgap(5);

        String[][] buttonLabels = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", "round", "C", "+"}
        };

        for (int row = 0; row < buttonLabels.length; row++) {
            for (int col = 0; col < buttonLabels[row].length; col++) {
                Button btn = new Button(buttonLabels[row][col]);
                btn.setMinSize(50, 50);

                buttonsGrid.add(btn, col, row);
            }
        }

        // Interface
        VBox root = new VBox(10, display, errorLabel, buttonsGrid);
        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: #f0f0f0;");

        // Add window
        Scene scene = new Scene(root, 250, 300);
        stage.setTitle("Calculator MVVM");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
