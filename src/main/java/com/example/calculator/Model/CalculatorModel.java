package com.example.calculator.Model;

public class CalculatorModel {
    private double accumulator;
    private double currentInput;

    // Setters
    public void setAccumulator(double num1) {
        this.accumulator = num1;
    }

    public void setCurrentInput(double num2) {
        this.currentInput = num2;
    }

    // Getters
    public double getAccumulator() {
        return accumulator;
    }

    public double getCurrentInput() {
        return currentInput;
    }

    // Checks
    public boolean isNotZero(double num) {
        return num != 0;
    }

    // Operations
}
