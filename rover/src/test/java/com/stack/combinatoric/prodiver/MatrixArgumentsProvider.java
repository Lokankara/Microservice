package com.stack.combinatoric.prodiver;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class MatrixArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext)
            throws Exception {
        return Stream.of(
                Arguments.of(3, new int[][]{{1, 2, 3}, {6, 5, 4}, {7, 8, 9}}),
                Arguments.of(2, new int[][]{{1, 2}, {4, 3}}),
                Arguments.of(4, new int[][]{{1, 2, 3, 4}, {8, 7, 6, 5}, {9, 10, 11, 12}, {16, 15, 14, 13}})
        );
    }
}
