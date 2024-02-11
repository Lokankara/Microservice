package com.stack.structure.string.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class CalculatorArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(
                        BigDecimal.valueOf(5), BigDecimal.valueOf(2),
                        BigDecimal.valueOf(7), BigDecimal.valueOf(3),
                        BigDecimal.valueOf(10), BigDecimal.valueOf(2.50)
                ),
                Arguments.of(
                        BigDecimal.valueOf(-5), BigDecimal.valueOf(-2),
                        BigDecimal.valueOf(-7), BigDecimal.valueOf(-3),
                        BigDecimal.valueOf(10), BigDecimal.valueOf(2.50)
                ),
                Arguments.of(
                        BigDecimal.ZERO, BigDecimal.valueOf(5),
                        BigDecimal.valueOf(5), BigDecimal.valueOf(-5),
                        BigDecimal.ZERO, BigDecimal.valueOf(0.00)
                ),
                Arguments.of(
                        BigDecimal.valueOf(10), BigDecimal.ZERO,
                        BigDecimal.valueOf(10), BigDecimal.valueOf(10),
                        BigDecimal.ZERO, BigDecimal.valueOf(1E10)
                )
        );
    }
}
