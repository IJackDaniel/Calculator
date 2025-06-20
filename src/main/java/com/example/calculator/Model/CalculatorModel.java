package com.example.calculator.Model;

public class CalculatorModel {
    private double accumulator;
    private double currentInput;
    private int accuracy = 5;
    double EPSILON = 0.0000001;
    private String operation;

    // standard constructor
    public CalculatorModel() { }

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

    public void setOperation(String op) {
        moveValues();
        operation = op;
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

    public String getOperation() {
        return operation;
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

    private void moveValues() {
        accumulator = currentInput;
        currentInput = 0.0;
    }

    // Operations
    public void roundAccumulator() {
        if (!isInteger(currentInput)) {
            currentInput = 0;
            throw new IllegalArgumentException("Second number must be integer");
        }
        currentInput = round(accumulator, (int) currentInput);
    }

    public void add() {
        currentInput = round(accumulator + currentInput, accuracy);
    }

    public void subtract() {
        currentInput = round(accumulator - currentInput, accuracy);
    }

    public void multiplication() {
        currentInput = round(accumulator * currentInput, accuracy);
    }

    public void division() {
        if (!isNotZero(currentInput)) {
            throw new IllegalArgumentException("Second number must not be zero");
        }
        currentInput = round(accumulator / currentInput, accuracy);
    }

    public void clear() {
        accumulator = 0;
        currentInput = 0;
    }

    public void execute() {
        System.out.println("Выполняю");
        System.out.println(getAccumulator());
        System.out.println(getCurrentInput());
        System.out.println(getOperation());
        switch (operation) {
            case "+":
                add();
                break;
            case "-":
                subtract();
                break;
            case "*":
                multiplication();
                break;
            case "/":
                division();
                break;
            case "round":
                roundAccumulator();
                break;
            case "C":
                clear();
                break;
            default:
                throw new IllegalArgumentException("Operation not selected");
        }
        operation = "";

        System.out.println("Готово!");
        System.out.println(getAccumulator());
        System.out.println(getCurrentInput());
        System.out.println(getOperation());
    }
}
