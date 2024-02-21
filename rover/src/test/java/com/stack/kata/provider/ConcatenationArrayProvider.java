package com.stack.kata.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ConcatenationArrayProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1}, new int[]{1, 2, 1, 1, 2, 1}),
                Arguments.of(new int[]{1, 3, 2, 1}, new int[]{1, 3, 2, 1, 1, 3, 2, 1}),
                Arguments.of(new int[]{1}, new int[]{1, 1}),
                Arguments.of(new int[]{1, 2}, new int[]{1, 2, 1, 2}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3, 1, 2, 3}),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4, 1, 2, 3, 4}),
                Arguments.of(new int[]{2, 2, 2, 2}, new int[]{2, 2, 2, 2, 2, 2, 2, 2}),
                Arguments.of(new int[]{3, 5, 7}, new int[]{3, 5, 7, 3, 5, 7}),
                Arguments.of(new int[]{4, 6, 8, 10}, new int[]{4, 6, 8, 10, 4, 6, 8, 10}),
                Arguments.of(new int[]{7, 8, 9, 10}, new int[]{7, 8, 9, 10, 7, 8, 9, 10}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}),
                Arguments.of(new int[]{2, 4, 6, 8, 10}, new int[]{2, 4, 6, 8, 10, 2, 4, 6, 8, 10}),
                Arguments.of(new int[]{3, 3, 3, 3, 3, 3}, new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}),
                Arguments.of(new int[]{5, 7, 9, 5, 7}, new int[]{5, 7, 9, 5, 7, 5, 7, 9, 5, 7}),
                Arguments.of(new int[]{6, 6, 6, 6, 6, 6, 6}, new int[]{6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}),
                Arguments.of(new int[]{2, 2}, new int[]{2, 2, 2, 2}),
                Arguments.of(new int[]{3, 3, 3}, new int[]{3, 3, 3, 3, 3, 3}),
                Arguments.of(new int[]{1000, 1000}, new int[]{1000, 1000, 1000, 1000}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3, 1, 2, 3}),
                Arguments.of(new int[]{3, 2, 1}, new int[]{3, 2, 1, 3, 2, 1}),
                Arguments.of(new int[]{100, 200, 300}, new int[]{100, 200, 300, 100, 200, 300}),
                Arguments.of(new int[]{500, 700, 900}, new int[]{500, 700, 900, 500, 700, 900}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 1}),
                Arguments.of(new int[]{100, 200, 300, 400}, new int[]{100, 200, 300, 400, 100, 200, 300, 400}),
                Arguments.of(new int[]{900, 800, 700, 600, 500}, new int[]{900, 800, 700, 600, 500, 900, 800, 700, 600, 500}),
                Arguments.of(new int[]{1, 3, 5, 7, 9}, new int[]{1, 3, 5, 7, 9, 1, 3, 5, 7, 9}),
                Arguments.of(new int[]{1000, 998, 996, 994, 992}, new int[]{1000, 998, 996, 994, 992, 1000, 998, 996, 994, 992}),
                Arguments.of(new int[]{1000}, new int[]{1000, 1000})
        );
    }
}
