package com.stack.streams.providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class StatisticsArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext)
            throws Exception {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 3.0, 1, 5),
                Arguments.of(Arrays.asList(2, 4, 6, 8, 10), 6.0, 2, 10),
                Arguments.of(Arrays.asList(-1, -2, -3, -4, -5), -3.0, -5, -1),
                Arguments.of(Arrays.asList(10, 20, 30, 40, 50), 30.0, 10, 50),
                Arguments.of(Arrays.asList(5, 10, 15, 20, 25), 15.0, 5, 25),
                Arguments.of(Arrays.asList(-5, -10, -15, -20, -25), -15.0, -25, -5),
                Arguments.of(Arrays.asList(1, 1, 1, 1, 1), 1.0, 1, 1),
                Arguments.of(Arrays.asList(2, 3, 5, 7, 11), 5.6, 2, 11),
                Arguments.of(Arrays.asList(10, 9, 8, 7, 6), 8.0, 6, 10),
                Arguments.of(Arrays.asList(-2, -3, -5, -7, -11), -5.6, -11, -2),
                Arguments.of(Arrays.asList(1, -2, 3, -4), -0.5, -4, 3),
                Arguments.of(Arrays.asList(0, 0, 0), 0.0, 0, 0),
                Arguments.of(Arrays.asList(Integer.MIN_VALUE, Integer.MAX_VALUE), (double) (Integer.MIN_VALUE + Integer.MAX_VALUE) / 2.0, Integer.MIN_VALUE, Integer.MAX_VALUE),
                Arguments.of(Arrays.asList(100, 50), 75.0, 50, 100),
                Arguments.of(Arrays.asList(-5, 10), 2.5, -5, 10),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 3.0, 1, 5),
                Arguments.of(Arrays.asList(99, 99, 99, 100), 99.25, 99, 100),
                Arguments.of(Arrays.asList(-100, -100, -100, -99), -99.75, -100, -99)
        );
    }
}
