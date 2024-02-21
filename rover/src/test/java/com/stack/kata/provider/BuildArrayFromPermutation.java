package com.stack.kata.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class BuildArrayFromPermutation
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(new int[]{0, 2, 1, 5, 3, 4}, new int[]{0, 1, 2, 4, 5, 3}),
                Arguments.of(new int[]{5, 0, 1, 2, 3, 4}, new int[]{4, 5, 0, 1, 2, 3}),
                Arguments.of(new int[]{1, 0}, new int[]{0, 1}),
                Arguments.of(new int[]{3, 0, 1, 2}, new int[]{2, 3, 0, 1}),
                Arguments.of(new int[]{4, 1, 0, 3, 2}, new int[]{2, 1, 4, 3, 0}),
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{2, 0, 1}, new int[]{1, 2, 0}),
                Arguments.of(new int[]{0, 2, 1, 5, 3, 4}, new int[]{0, 1, 2, 4, 5, 3}),
                Arguments.of(new int[]{5, 0, 1, 2, 3, 4}, new int[]{4, 5, 0, 1, 2, 3}),
                Arguments.of(new int[]{2, 0, 1, 3}, new int[]{1, 2, 0, 3}),
                Arguments.of(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}),
                Arguments.of(new int[]{0, 1, 2, 3, 5, 4}, new int[]{0, 1, 2, 3, 4, 5}),
                Arguments.of(new int[]{6, 5, 4, 3, 2, 1, 0}, new int[]{0, 1, 2, 3, 4, 5, 6}),
                Arguments.of(new int[]{2, 3, 0, 1}, new int[]{0, 1, 2, 3}),
                Arguments.of(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}),
                Arguments.of(new int[]{3, 1, 4, 2, 0}, new int[]{2, 1, 0, 4, 3}),
                Arguments.of(new int[]{1, 2, 0}, new int[]{2, 0, 1}),
                Arguments.of(new int[]{2, 3, 0, 1}, new int[]{0, 1, 2, 3}),
                Arguments.of(new int[]{4, 2, 3, 0, 1}, new int[]{1, 3, 0, 4, 2}),
                Arguments.of(new int[]{0, 9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}),
                Arguments.of(new int[]{5, 4, 3, 2, 1, 0, 9, 8, 7, 6}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}),
                Arguments.of(new int[]{1, 0, 3, 2}, new int[]{0, 1, 2, 3})
        );
    }
}
