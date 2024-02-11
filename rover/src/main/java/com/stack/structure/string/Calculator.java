package com.stack.structure.string;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {

    BigDecimal sum(
            BigDecimal a,
            BigDecimal b) {
        return a.add(b);
    }

    BigDecimal subtract(
            BigDecimal a,
            BigDecimal b) {
        return a.subtract(b);
    }

    BigDecimal multiply(
            BigDecimal a,
            BigDecimal b) {
        return a.multiply(b);
    }

    BigDecimal divide(BigDecimal a, BigDecimal b) {
        if (b.compareTo(BigDecimal.ZERO) != 0) {
            return a.divide(b, 2, RoundingMode.HALF_UP);
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }

    public static String countingSheep(int num) {
        return IntStream
                .rangeClosed(1, num)
                .mapToObj(i -> i + " sheep...")
                .collect(Collectors.joining());
    }
}
