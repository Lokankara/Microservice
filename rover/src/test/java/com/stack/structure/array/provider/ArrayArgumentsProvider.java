package com.stack.structure.array.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

public class ArrayArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(of(new int[]{9, 2, 6, 4, 5, 12, 7, 8, 6}, 59),
                         of(new int[]{9, 2, 6, 4, 5, 12, 7, 6, 8}, 59),
                         of(new int[]{-9, -2, -6, -4, -5, -12, -7, -8, -6}, -59),
                         of(new int[]{9, -2, 6, -4, 5, -12, 7, -8, 6}, 7),
                         of(new int[]{9, 2, 6, 4, 5, 12, 7, 7, 8, 6}, 66),
                         of(new int[]{1, 2, 3, 4, 5, 6, 7, 7, 8, 9}, 52),
                         of(new int[]{10, -5}, 5),
                         of(new int[]{}, 0),
                         of(new int[]{10}, 10));
    }
}
