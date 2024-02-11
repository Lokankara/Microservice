package com.stack.kata;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ProductArrayArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(new int[]{1, 2, 3, 4},
                                      new long[]{24, 12, 8, 6}),
                         Arguments.of(new int[]{2, 3, 4, 5},
                                      new long[]{60, 40, 30, 24}),
                         Arguments.of(new int[]{5, 10, 15},
                                      new long[]{150, 75, 50}),
                         Arguments.of(new int[]{1, 1, 1}, new long[]{1, 1, 1}));
    }
}
