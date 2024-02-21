package com.stack.kata.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class SmallerNumbersThanCurrentArrayProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(new int[]{8, 1, 2, 2, 3}, new int[]{4, 0, 1, 1, 3}),
                Arguments.of(new int[]{6, 5, 4, 8}, new int[]{2, 1, 0, 3}),
                Arguments.of(new int[]{7, 7, 7, 7}, new int[]{0, 0, 0, 0})
        );
    }
}
