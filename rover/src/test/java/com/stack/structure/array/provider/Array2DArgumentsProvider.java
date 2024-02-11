package com.stack.structure.array.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class Array2DArgumentsProvider
        implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 45, 9),
                Arguments.of(new int[][]{{-1, -2, -3}, {-4, -5, -6}, {-7, -8, -9}}, -45, -1),
                Arguments.of(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, 0, 0),
                Arguments.of(new int[][]{{1, -2, 3}, {-4, 5, -6}, {7, -8, 9}}, 5, 9),
                Arguments.of(new int[][]{{10, 20, 30}, {40, 50, 60}, {70, 80, 90}}, 450, 90),
                Arguments.of(new int[][]{{-10, -20, -30}, {-40, -50, -60}, {-70, -80, -90}}, -450, -10),
                Arguments.of(new int[][]{{1, 2}, {3, 4}}, 10, 4),
                Arguments.of(new int[][]{{-1, -2}, {-3, -4}}, -10, -1),
                Arguments.of(new int[][]{{0, 0}, {0, 0}}, 0, 0),
                Arguments.of(new int[][]{{1}, {2}}, 3, 2),
                Arguments.of(new int[][]{{10}}, 10, 10),
                Arguments.of(new int[][]{{-10}}, -10, -10),
                Arguments.of(new int[][]{}, 0, Integer.MIN_VALUE),
                Arguments.of(new int[][]{{-1}, {-2}}, -3, -1),
                Arguments.of(new int[][]{{0}, {0}}, 0, 0),
                Arguments.of(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9}, {-1, -2, -3, -4}, {-5, -6}}, 24, 9),
                Arguments.of(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9}, {-1, -2, -3, -4}, {-5, -6, -7}}, 17, 9),
                Arguments.of(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9}, {-1, -2, -3, -4}, {-5, -6, -7, -8}}, 9, 9)
        );
    }
}
