package com.stack.thread;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class IntegralCalculatorArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(0, 1, 1000, 0, 4, new double[4]),
                         Arguments.of(0, 1, 1000, 1, 4, new double[4]),
                         Arguments.of(0, 1, 1000, 0, 4, new double[4]),
                         Arguments.of(0, 2, 2000, 1, 4, new double[4]),
                         Arguments.of(1, 3, 3000, 2, 4, new double[4]),
                         Arguments.of(1, 4, 4000, 3, 4, new double[4]),
                         Arguments.of(2, 5, 5000, 0, 5, new double[5]),
                         Arguments.of(2, 6, 6000, 1, 5, new double[5]),
                         Arguments.of(3, 7, 7000, 2, 5, new double[5]),
                         Arguments.of(3, 8, 8000, 3, 5, new double[5]),
                         Arguments.of(3, 9, 9000, 4, 5, new double[5])
        );
    }
}
