package com.example.calculator.Model;

public class CalculatorModel {
    private double accumulator;
    private double currentInput;
    private int accuracy = 5;
    double EPSILON = 0.0000001;

    // standard constructor
    CalculatorModel() { }

    // constructor for tests
    CalculatorModel(double num1, double num2) {
        accumulator = num1;
        currentInput = num2;
    }

    // Setters
    public void setAccumulator(double num) {
        accumulator = num;
    }

    public void setCurrentInput(double num) {
        currentInput = num;
    }

    public void setAccuracy(int num) {
        accuracy = num;
    }

    // Getters
    public double getAccumulator() {
        return accumulator;
    }

    public double getCurrentInput() {
        return currentInput;
    }

    public int getAccuracy() {
        return accuracy;
    }

    // Checks and internal operations
    private boolean isNotZero(double num) {
        return Math.abs(num) > EPSILON;
    }

    private boolean isInteger(double num) {
        return num == (int) num;
    }

    private double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    // Operations
    public void roundAccumulator() {
        if (!isInteger(currentInput)) {
            currentInput = 0;
            throw new IllegalArgumentException("Second number must be integer");
        }
        accumulator = round(accumulator, (int) currentInput);
    }

    public void add() {
        accumulator = round(accumulator + currentInput, accuracy);
        currentInput = 0;
    }

    public void subtract() {
        accumulator = round(accumulator - currentInput, accuracy);
        currentInput = 0;
    }

    public void multiplication() {
        accumulator = round(accumulator * currentInput, accuracy);
        currentInput = 0;
    }

    public void division() {
        if (!isNotZero(currentInput)) {
            throw new IllegalArgumentException("Second number must not be zero");
        }
        accumulator = round(accumulator / currentInput, accuracy);
        currentInput = 0;
    }

    public void clear() {
        accumulator = 0;
        currentInput = 0;
    }
}
