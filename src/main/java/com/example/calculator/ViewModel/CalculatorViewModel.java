package com.example.calculator.ViewModel;

import com.example.calculator.Model.CalculatorModel;
import javafx.beans.property.*;

public class CalculatorViewModel {
    private final CalculatorModel model = new CalculatorModel();

    // Properties for binding with View
    private final StringProperty displayText = new SimpleStringProperty("");
    private final StringProperty errorText = new SimpleStringProperty("");

    // Getters for properties
    public StringProperty getDisplayTextProperty () { return displayText; }
    public StringProperty getErrorTextProperty () { return errorText; }

    public void handleDigit(String digit) {
        try {
            clearErrorText();
            String newValue = displayText.get().isEmpty() ? digit : displayText.get() + digit;
            displayText.set(newValue);
            model.setCurrentInput(Double.parseDouble(newValue));
        } catch (NumberFormatException e) {
            errorText.set("Invalid input");
        }
    }

    public void handleOperation(String op) {
        try {
            clearErrorText();
            clearDisplay();
            if (!op.equals("=")) {
                model.setOperation(op);
            }

            switch (op) {
                case "C" -> model.clear();
                case "=" -> model.execute();
            }

            if (op.equals("=")) {
            updateDisplay();
            }
        } catch (IllegalArgumentException e) {
            errorText.set(e.getMessage());
        }
    }

    public void handleDot(String op) {
        try {
            if (!displayText.get().contains(".")) {
                displayText.set(displayText.get() + ".");
            } else {
                throw new IllegalArgumentException("The dot is already there");
            }
        } catch (IllegalArgumentException e) {
            errorText.set(e.getMessage());
        }
    }

    private void clearDisplay() {
        displayText.set("");
    }

    private void clearErrorText() {
        errorText.set("");
    }

    private void updateDisplay() {
        if (model.getCurrentInput() == (int) model.getCurrentInput()) {
            displayText.set(String.valueOf((int) model.getCurrentInput()));
        } else {
            displayText.set(String.valueOf(model.getCurrentInput()));
        }

    }
}
