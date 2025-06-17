package com.example.calculator.ViewModel;

import com.example.calculator.Model.CalculatorModel;
import javafx.beans.property.*;

public class CalculatorViewModel {
    private final CalculatorModel model = new CalculatorModel();

    // Properties for binding with View
    private final StringProperty displayText = new SimpleStringProperty("");
    private final StringProperty errorText = new SimpleStringProperty("");

    // Other
    private int inputChoice = 1;

    // Getters for properties
    public StringProperty getDisplayTextProperty () { return displayText; }
    public StringProperty getErrorTextProperty () { return errorText; }

    public void handleDigit(String digit) {
        try {
            String newValue = displayText.get().equals("0.0") ? digit : displayText.get() + digit;
            displayText.set(newValue);
            switch (inputChoice) {
                case 1:
                    System.out.println("ACC");
                    System.out.println(newValue);
                    model.setAccumulator(Double.parseDouble(newValue));
                    break;
                case 2:
                    System.out.println("CUR");
                    System.out.println(newValue);
                    model.setCurrentInput(Double.parseDouble(newValue));
                    break;
            }

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
                case "+", "-", "*", "/" -> { inputChoice = 2; displayText.set("0.0");}
                case "round" -> inputChoice = 1; //???????????
                case "C" -> inputChoice = 1;
                case "=" -> {inputChoice = 3; model.execute();}
            }
            updateDisplay();
        } catch (IllegalArgumentException e) {
            errorText.set(e.getMessage());
        }
    }

    private void updateDisplay() {
        switch (inputChoice) {
            case 1:
                displayText.set(String.valueOf(model.getAccumulator()));
                break;
            case 2:
                displayText.set(String.valueOf(model.getCurrentInput()));
                break;
            case 3:
                displayText.set(String.valueOf(model.getAccumulator()));
                inputChoice = 2;
        }

    }
}
