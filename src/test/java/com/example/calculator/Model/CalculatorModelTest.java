package com.example.calculator.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorModelTest {
    @Test
    void testAddWithPositiveNumbers() {
        CalculatorModel model = new CalculatorModel();
        model.setAccumulator(5);
        model.setCurrentInput(7);

        model.add();
        assertEquals(12, model.getAccumulator());
    }

    @Test
    void testAddWithNegativeNumbers() {
        CalculatorModel model = new CalculatorModel();
        model.setAccumulator(-12);
        model.setCurrentInput(88);

        model.add();
        assertEquals(76, model.getAccumulator());
    }

    @Test
    void testAddWithDoubleNumbers() {
        CalculatorModel model = new CalculatorModel();
        model.setAccumulator(-12.2);
        model.setCurrentInput(4.7);

        model.add();
        assertEquals(-7.5, model.getAccumulator());
    }

    @Test
    void testRoundFunctionWith1() {
        CalculatorModel model = new CalculatorModel();
        model.setAccumulator(-43.57);
        model.setCurrentInput(1);

        model.roundAccumulator();
        assertEquals(-43.6, model.getAccumulator());
    }

    @Test
    void testRoundFunctionWith2() {
        CalculatorModel model = new CalculatorModel();
        model.setAccumulator(0.85346);
        model.setCurrentInput(2);

        model.roundAccumulator();
        assertEquals(0.85, model.getAccumulator());
    }

    @Test
    void testRoundFunctionWith4() {
        CalculatorModel model = new CalculatorModel();
        model.setAccumulator(5.4563444);
        model.setCurrentInput(4);

        model.roundAccumulator();
        assertEquals(5.4563, model.getAccumulator());
    }

    /*

    @Test
    void testName() {
        CalculatorModel model = new CalculatorModel();
        // Body of the test
    }

     */
}
