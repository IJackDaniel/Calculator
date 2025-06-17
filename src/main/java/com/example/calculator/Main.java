package com.example.calculator;

import com.example.calculator.View.CalculatorView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        new CalculatorView().start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}