package com.stack.structure.string;

import com.stack.structure.string.provider.CalculatorArgumentsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @ArgumentsSource(CalculatorArgumentsProvider.class)
    void testOperations(BigDecimal a, BigDecimal b, BigDecimal sum, BigDecimal sub, BigDecimal multi, BigDecimal div) {
        assertEquals(sum, calculator.sum(a, b));
        assertEquals(sub, calculator.subtract(a, b));
        assertEquals(multi, calculator.multiply(a, b));
        if (b.compareTo(BigDecimal.ZERO) == 0) {
            assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
        } else {
            assertEquals(div.stripTrailingZeros(), calculator.divide(a, b).stripTrailingZeros());
        }
    }

    @ParameterizedTest
    @ArgumentsSource(CalculatorArgumentsProvider.class)
    void testSum(BigDecimal a, BigDecimal b, BigDecimal sum, BigDecimal sub, BigDecimal multi, BigDecimal div) {
        BigDecimal actual = calculator.sum(a, b);
        assertEquals(a, calculator.subtract(actual, b));
        assertEquals(b, calculator.subtract(actual, a));
        assertEquals(sum, actual);
    }

    @ParameterizedTest
    @ArgumentsSource(CalculatorArgumentsProvider.class)
    void testSubtract(BigDecimal a, BigDecimal b, BigDecimal sum, BigDecimal sub, BigDecimal multi, BigDecimal div) {
        BigDecimal actual = calculator.subtract(a, b);
        assertEquals(a, calculator.sum(actual, b));
        assertEquals(sub, actual);
    }

    @ParameterizedTest
    @ArgumentsSource(CalculatorArgumentsProvider.class)
    void testMultiply(BigDecimal a, BigDecimal b, BigDecimal sum, BigDecimal sub, BigDecimal multi, BigDecimal div) {
        BigDecimal actual = calculator.multiply(a, b);
        assertEquals(multi, actual);
    }

    @ParameterizedTest
    @ArgumentsSource(CalculatorArgumentsProvider.class)
    void testDivideByZero(BigDecimal a, BigDecimal b, BigDecimal sum, BigDecimal sub, BigDecimal multi, BigDecimal div) {
        if (b.compareTo(BigDecimal.ZERO) == 0) {
            assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
        } else {
            assertEquals(div.stripTrailingZeros(), calculator.divide(a, b).stripTrailingZeros());
        }
    }
}
