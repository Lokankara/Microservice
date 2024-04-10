package com.stack.streams.providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SumOfOddNumbersArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext)
            throws Exception {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 25),
                Arguments.of(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 0),
                Arguments.of(Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4), -5),
                Arguments.of(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20), 0),
                Arguments.of(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19), 100),
                Arguments.of(Arrays.asList(-10, -8, -6, -4, -2, 0, 2, 4, 6, 8), 0),
                Arguments.of(Arrays.asList(100, 200, 300, 400, 500, 601, 700, 800, 900, 1000), 601),
                Arguments.of(Arrays.asList(5, 15, 25, 35, 45, 55, 65, 75, 85, 95), 500),
                Arguments.of(Arrays.asList(-1, -2, -3, -4, -5, -6, -7, -8, -9, -10), -25),
                Arguments.of(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 25),
                Arguments.of(Arrays.asList(1, 3, 5), 9),
                Arguments.of(Arrays.asList(2, 4, 6), 0),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 9),
                Arguments.of(Arrays.asList(-1, 0, 1, 2), 0),
                Arguments.of(List.of(), 0),
                Arguments.of(List.of(1), 1),
                Arguments.of(Arrays.asList(1, 1, 1), 3),
                Arguments.of(Arrays.asList(Integer.MAX_VALUE, 1), Integer.MIN_VALUE),
                Arguments.of(Arrays.asList(Integer.MIN_VALUE, 1), 1),
                Arguments.of(Arrays.asList(Integer.MAX_VALUE / 2, Integer.MIN_VALUE / 2), Integer.MAX_VALUE / 2)
        );
    }
}
