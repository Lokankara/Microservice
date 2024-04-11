package com.stack.streams.providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.List;
import java.util.stream.Stream;

public class ZeroDigitsArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context)
            throws Exception {
        return Stream.of(
                Arguments.of(List.of(0), List.of(0)),
                Arguments.of(List.of(1, 2, 3), List.of()),
                Arguments.of(List.of(0, 0, 0), List.of(0, 0, 0)),
                Arguments.of(List.of(0, 1, 2, 0, 3, 0), List.of(0, 0, 0)),
                Arguments.of(List.of(9, 8, 7, 6, 5), List.of()),
                Arguments.of(List.of(), List.of()),
                Arguments.of(List.of(0, 0, 0, 0, 0), List.of(0, 0, 0, 0, 0)),
                Arguments.of(List.of(1, 0, 1, 0, 1), List.of(0, 0)),
                Arguments.of(List.of(2, 2, 2, 2, 2), List.of()),
                Arguments.of(List.of(0, 3, 0, 3, 0), List.of(0, 0, 0)),
                Arguments.of(List.of(0, 0, 4, 4, 4), List.of(0, 0)),
                Arguments.of(List.of(5, 5, 5, 5, 0), List.of(0)),
                Arguments.of(List.of(0, 6, 0, 6, 6), List.of(0, 0)),
                Arguments.of(List.of(7, 0, 7, 0, 7), List.of(0, 0)),
                Arguments.of(List.of(0, 8, 0, 8, 8), List.of(0, 0)),
                Arguments.of(List.of(9, 0, 9, 9, 9), List.of(0)),
                Arguments.of(List.of(0, 0, 0, 0, 0, 0), List.of(0, 0, 0, 0, 0, 0)),
                Arguments.of(List.of(0, 1, 0, 1, 0, 1), List.of(0, 0, 0)),
                Arguments.of(List.of(2, 0, 2, 0, 2, 0), List.of(0, 0, 0)),
                Arguments.of(List.of(0, 3, 0, 3, 0, 3), List.of(0, 0, 0)),
                Arguments.of(List.of(4, 0, 4, 0, 4, 0), List.of(0, 0, 0)),
                Arguments.of(List.of(0, 5, 0, 5, 0, 5), List.of(0, 0, 0)),
                Arguments.of(List.of(6, 0, 6, 0, 6, 0), List.of(0, 0, 0)),
                Arguments.of(List.of(0, 7, 0, 7, 0, 7), List.of(0, 0, 0)),
                Arguments.of(List.of(8, 0, 8, 0, 8, 0), List.of(0, 0, 0)),
                Arguments.of(List.of(0, 9, 0, 9, 0, 9), List.of(0, 0, 0))
        );
    }
}
