package com.example.calculator.Model;

public class CalculatorModel {
    private double num1;
    private double num2;
    private double result;

    // Setters
    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setResult(double result) {
        this.result = result;
    }

    // Getters
    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public double getResult() {
        return result;
    }

    // Checks
    private boolean isNotZero(double num) {
        return num != 0;
    }

    // Operations
}
