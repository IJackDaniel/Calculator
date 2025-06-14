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

    // Checks and internal operations
    private boolean isNotZero(double num) {
        return num != 0;
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
        if (isInteger(this.currentInput)) {
            this.accumulator = round(this.accumulator, (int) this.currentInput);
        }
        else {
            System.out.println("Second number is not Integer!");
        }
    }

    public void add() {
        this.accumulator = round(this.accumulator + this.currentInput, 4);
        this.currentInput = 0;
    }
}
