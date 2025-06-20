package com.example.calculator.View;

import com.example.calculator.ViewModel.CalculatorViewModel;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CalculatorView extends Application{
    private final CalculatorViewModel viewModel = new CalculatorViewModel();

    @Override
    public void start(Stage stage) {
        // Create elements of control
        TextField display = new TextField();
        display.setEditable(false);
        display.textProperty().bind(viewModel.getDisplayTextProperty());

        Label errorLabel = new Label();
        errorLabel.textProperty().bind(viewModel.getErrorTextProperty());
        errorLabel.setStyle("-fx-text-fill: red;");

        // Add buttons
        GridPane buttonsGrid = new GridPane();
        buttonsGrid.setHgap(5);
        buttonsGrid.setVgap(5);

        String[][] buttonLabels = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"C", "0", ".", "+"}
        };

        for (int row = 0; row < buttonLabels.length; row++) {
            for (int col = 0; col < buttonLabels[row].length; col++) {
                Button btn = new Button(buttonLabels[row][col]);
                btn.setMinSize(50, 50);

                String buttonText = buttonLabels[row][col];

                if (Character.isDigit(buttonText.charAt(0))) {
                    btn.setOnAction(e -> viewModel.handleDigit(buttonText));
                } else if (buttonText.equals(".")) {
                    btn.setOnAction(e -> viewModel.handleDot(buttonText));
                } else {
                    btn.setOnAction(e -> viewModel.handleOperation(buttonText));
                }

                buttonsGrid.add(btn, col, row);
            }
        }

        // Create split equals and round buttons
        HBox splitButtons = new HBox(5);
//        splitButtons.setMaxWidth(240);

        Button roundBtn = new Button("round");
        roundBtn.setMinSize(60, 50);
        roundBtn.setOnAction(e -> viewModel.handleOperation("round"));

        Button equalsBtn = new Button("=");
        equalsBtn.setMinHeight(50);
        equalsBtn.setMaxWidth(Double.MAX_VALUE);
        equalsBtn.setStyle("-fx-font-size: 18px;");
        equalsBtn.setOnAction(e -> viewModel.handleOperation("="));

        HBox.setHgrow(equalsBtn, Priority.ALWAYS);
        splitButtons.getChildren().addAll(roundBtn, equalsBtn);

//        Button equalsBtn = new Button("=");
//        equalsBtn.setMinHeight(50);
//        equalsBtn.setMaxWidth(240);
//        equalsBtn.setStyle("-fx-font-size: 18px;");
//        equalsBtn.setOnAction(e -> viewModel.handleOperation("="));

        // Interface
        VBox root = new VBox(10, display, errorLabel, buttonsGrid, splitButtons);
        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: #f0f0f0;");

        // Add window
        Scene scene = new Scene(root, 235, 350);
        stage.setTitle("Calculator MVVM");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
