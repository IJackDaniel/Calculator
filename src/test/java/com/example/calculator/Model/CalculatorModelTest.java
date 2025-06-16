package com.example.calculator.Model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorModelTest {

    @Nested
    class RoundTests {
        @Test
        void testRoundFunctionWith1() {
            CalculatorModel model = new CalculatorModel(-43.57, 1);
            model.roundAccumulator();
            assertEquals(-43.6, model.getAccumulator(), 0.0001);
        }

        @Test
        void testRoundFunctionWith2() {
            CalculatorModel model = new CalculatorModel(0.85346, 2);
            model.roundAccumulator();
            assertEquals(0.85, model.getAccumulator(), 0.0001);
        }

        @Test
        void testRoundFunctionWith4() {
            CalculatorModel model = new CalculatorModel(5.4563444, 4);
            model.roundAccumulator();
            assertEquals(5.4563, model.getAccumulator(), 0.0001);
        }

        @Test
        void testRoundFunctionWithNoIntValue() {
            CalculatorModel model = new CalculatorModel(3.563, 4.5);

            Exception exception = assertThrows(
                    IllegalArgumentException.class,
                    model::roundAccumulator
            );

            assertEquals("Second number must be integer", exception.getMessage());
            assertEquals(3.563, model.getAccumulator(), 0.0001);
            assertEquals(0, model.getCurrentInput(), 0.0001);
        }
    }

    @Nested
    class AddTests {
        @Test
        void testAddWithPositiveNumbers() {
            CalculatorModel model = new CalculatorModel(5, 7);
            model.add();
            assertEquals(12, model.getAccumulator(), 0.0001);
        }

        @Test
        void testAddWithNegativeNumbers() {
            CalculatorModel model = new CalculatorModel(-12, 88);
            model.add();
            assertEquals(76, model.getAccumulator(), 0.0001);
        }

        @Test
        void testAddWithDoubleNumbers() {
            CalculatorModel model = new CalculatorModel(-12.2, 4.7);
            model.add();
            assertEquals(-7.5, model.getAccumulator(), 0.0001);
        }
    }

    @Nested
    class SubtractionTests {
        @Test
        void testSubtractWithPositiveNumbers1() {
            CalculatorModel model = new CalculatorModel(9, 4);
            model.subtract();
            assertEquals(5, model.getAccumulator(), 0.0001);
        }

        @Test
        void testSubtractWithPositiveNumbers2() {
            CalculatorModel model = new CalculatorModel(13, 27);
            model.subtract();
            assertEquals(-14, model.getAccumulator(), 0.0001);
        }

        @Test
        void testSubtractWithNegativeNumbers() {
            CalculatorModel model = new CalculatorModel(-6, 33);
            model.subtract();
            assertEquals(-39, model.getAccumulator(), 0.0001);
        }

        @Test
        void testSubtractWithDoubleNumbers1() {
            CalculatorModel model = new CalculatorModel(6.65, 2.35);
            model.subtract();
            assertEquals(4.3, model.getAccumulator(), 0.0001);
        }

        @Test
        void testSubtractWithDoubleNumbers2() {
            CalculatorModel model = new CalculatorModel(10, 2.3552);
            model.subtract();
            assertEquals(7.6448, model.getAccumulator());
        }
    }

    @Nested
    class MultiplicationTests {
        @Test
        void testMultiplicationWithPositiveNumbers1() {
            CalculatorModel model = new CalculatorModel(4, 5);
            model.multiplication();
            assertEquals(20, model.getAccumulator(), 0.0001);
        }

        @Test
        void testMultiplicationWithPositiveNumbers2() {
            CalculatorModel model = new CalculatorModel(777, 234);
            model.multiplication();
            assertEquals(181818, model.getAccumulator(), 0.0001);
        }

        @Test
        void testMultiplicationWithNegativeNumbers() {
            CalculatorModel model = new CalculatorModel(-9, 13);
            model.multiplication();
            assertEquals(-117, model.getAccumulator(), 0.0001);
        }

        @Test
        void testMultiplicationWithZero1() {
            CalculatorModel model = new CalculatorModel(56, 0);
            model.multiplication();
            assertEquals(0, model.getAccumulator(), 0.0001);
        }

        @Test
        void testMultiplicationWithZero2() {
            CalculatorModel model = new CalculatorModel(0, 34);
            model.multiplication();
            assertEquals(0, model.getAccumulator(), 0.0001);
        }

        @Test
        void testMultiplicationWithDoubleNumbers1() {
            CalculatorModel model = new CalculatorModel(2.25, 7);
            model.multiplication();
            assertEquals(15.75, model.getAccumulator(), 0.0001);
        }

        @Test
        void testMultiplicationWithDoubleNumbers2() {
            CalculatorModel model = new CalculatorModel(1.333, 2.45);
            model.multiplication();
            assertEquals(3.26585, model.getAccumulator(), 0.0001);
        }
    }

    @Nested
    class DivisionTests {
        @Test
        void testDivisionWithPositiveNumbers1() {
            CalculatorModel model = new CalculatorModel(1, 3);
            model.division();
            assertEquals(0.33333, model.getAccumulator(), 0.0001);
        }

        @Test
        void testDivisionWithPositiveNumbers2() {
            CalculatorModel model = new CalculatorModel(10, 2);
            model.division();
            assertEquals(5, model.getAccumulator(), 0.0001);
        }

        @Test
        void testDivisionWithNegativeNumbers1() {
            CalculatorModel model = new CalculatorModel(-16, 8);
            model.division();
            assertEquals(-2, model.getAccumulator(), 0.0001);
        }

        @Test
        void testDivisionWithNegativeNumbers2() {
            CalculatorModel model = new CalculatorModel(-2, -3);
            model.division();
            assertEquals(0.66667, model.getAccumulator(), 0.0001);
        }

        @Test
        void testDivisionWithZero1() {
            CalculatorModel model = new CalculatorModel(0, 1);
            model.division();
            assertEquals(0, model.getAccumulator(), 0.0001);
        }

        @Test
        void testDivisionWithZero2() {
            CalculatorModel model = new CalculatorModel(17, 0);

            Exception exception = assertThrows(
                    IllegalArgumentException.class,
                    model::division
            );

            assertEquals("Second number must not be zero", exception.getMessage());
            assertEquals(17, model.getAccumulator(), 0.0001);
        }
    }

    @Test
    void testCrearFunction() {
        CalculatorModel model = new CalculatorModel(23, 4);
        model.clear();
        assertEquals(0, model.getAccumulator(), 0.0001);
        assertEquals(0, model.getCurrentInput(), 0.0001);
    }
}
