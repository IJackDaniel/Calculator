package com.example.calculator.ViewModel;

import com.example.calculator.Model.CalculatorModel;
import javafx.beans.property.*;

public class CalculatorViewModel {
    private final CalculatorModel model = new CalculatorModel();

    // Properties for binding with View
    private final StringProperty displayText = new SimpleStringProperty("0");
    private final StringProperty errorText = new SimpleStringProperty("");

    // Getters for properties
    public StringProperty getDisplayTextProperty () { return displayText; }
    public StringProperty getErrorTextProperty () { return errorText; }

    public void handleDigit(String digit) {
        try {
            String newValue = displayText.get().equals("0") ? digit : displayText.get() + digit;
            displayText.set(newValue);
            model.setCurrentInput(Double.parseDouble(newValue));
        } catch (NumberFormatException e) {
            errorText.set("Invalid input");
        }
    }

    public void handleOperation(String op) {
        try {
            switch (op) {
                case "+" -> model.add();
                case "-" -> model.subtract();
                case "*" -> model.multiplication();
                case "/" -> model.division();
                case "round" -> model.roundAccumulator();
                case "C" -> model.clear();
            }
            updateDisplay();
        } catch (IllegalArgumentException e) {
            errorText.set(e.getMessage());
        }
    }

    private void updateDisplay() {
        displayText.set(String.valueOf(model.getAccumulator()));
    }
}
