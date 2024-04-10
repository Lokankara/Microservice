package com.stack.streams.providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class SecondLargestArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(
            ExtensionContext extensionContext)
            throws Exception {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 9),
                Arguments.of(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 0),
                Arguments.of(Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4), 3),
                Arguments.of(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20), 18),
                Arguments.of(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19), 17),
                Arguments.of(Arrays.asList(-10, -8, -6, -4, -2, 0, 2, 4, 6, 8), 6),
                Arguments.of(Arrays.asList(100, 200, 300, 400, 500, 600, 700, 800, 900, 1000), 900),
                Arguments.of(Arrays.asList(5, 15, 25, 35, 45, 55, 65, 75, 85, 95), 85),
                Arguments.of(Arrays.asList(-1, -2, -3, -4, -5, -6, -7, -8, -9, -10), -2),
                Arguments.of(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 8)
        );
    }
}
