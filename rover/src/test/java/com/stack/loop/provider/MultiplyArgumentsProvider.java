package com.stack.loop.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class MultiplyArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(0, 10, 2, new int[]{0, 2, 4, 6, 8}),
                Arguments.of(1, 11, 3, new int[]{3, 6, 9}),
                Arguments.of(10, 30, 5, new int[]{10, 15, 20, 25}),
                Arguments.of(5, 20, 7, new int[]{7, 14})
        );
    }
}
