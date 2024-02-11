package com.stack.structure.array.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class MatrixSumArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(3, 2, "1 2 3 4 5 6", new int[][]{{1, 3}, {2, 6}, {3, 9}}),
                Arguments.of(4, 4, "1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4\n", new int[][]{{1, 2, 3, 4}, {2, 4, 6, 8}, {3, 6, 9, 12}, {4, 8, 12, 16}}),
                Arguments.of(3, 3, "9 8 7 6 5 4 3 2 1\n", new int[][]{{9, 17, 24}, {18, 34, 48}, {27, 51, 72}}),
                Arguments.of(2, 5, "1 2 3 4 5 6 7 8 9 10\n", new int[][]{{1, 3, 6, 10, 15}, {2, 6, 12, 20, 30}}),
                Arguments.of(5, 2, "1 2 3 4 5 6 7 8 9 10\n", new int[][]{{1, 3}, {2, 6}, {3, 9}, {4, 12}, {5, 15}})
        );
    }
}
