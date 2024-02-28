package com.stack.thread;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntegralCalculatorTest {

    @ParameterizedTest
    @ArgumentsSource(IntegralCalculatorArgumentsProvider.class)
    void testIntegralCalculator(double a, double b, int n, int index, int size, double[] expected)
            throws InterruptedException {
        IntegralCalculator calculator = new IntegralCalculator(a, b, n, index, size, expected);
        Thread thread = new Thread(calculator);
        thread.start();
        thread.join();
        double[] actual = calculator.getResult();
        assertArrayEquals(actual, expected, "The expected array should be " + Arrays.toString(expected));
    }
}
