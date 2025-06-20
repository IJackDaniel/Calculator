package com.example.calculator.ViewModel;

import com.example.calculator.Model.CalculatorModel;
import javafx.beans.property.*;

public class CalculatorViewModel {
    private final CalculatorModel model = new CalculatorModel();

    // Properties for binding with View
    private final StringProperty displayText = new SimpleStringProperty("0.0");
    private final StringProperty errorText = new SimpleStringProperty("");

    // Getters for properties
    public StringProperty getDisplayTextProperty () { return displayText; }
    public StringProperty getErrorTextProperty () { return errorText; }

    public void handleDigit(String digit) {
        try {
            String newValue = displayText.get().equals("0.0") ? digit : displayText.get() + digit;
            displayText.set(newValue);
            model.setCurrentInput(Double.parseDouble(newValue));

            System.out.println("Такие числа:");
            System.out.println(model.getAccumulator());
            System.out.println(model.getCurrentInput());
        } catch (NumberFormatException e) {
            errorText.set("Invalid input");
        }
    }

    public void handleOperation(String op) {
        try {
            if (!op.equals("=")) {
                model.setOperation(op);
            }

            switch (op) {
                case "+", "-", "*", "/", "round" -> { model.setCurrentInput(0.0); displayText.set("0.0"); }
                case "C" -> model.clear();
                case "=" -> model.execute();
            }
            System.out.println("Такие числа:");
            System.out.println(model.getAccumulator());
            System.out.println(model.getCurrentInput());
            updateDisplay();
        } catch (IllegalArgumentException e) {
            errorText.set(e.getMessage());
        }
    }

    private void updateDisplay() {
        displayText.set(String.valueOf(model.getCurrentInput()));
    }
}
