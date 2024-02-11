package com.stack.combinatoric.prodiver;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class MirrorPrimeArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(10, 25, 3),
                         Arguments.of(100, 200, 12),
                         Arguments.of(1, 10, 4),
                         Arguments.of(20, 30, 0),
                         Arguments.of(30, 40, 2),
                         Arguments.of(70, 80, 3),
                         Arguments.of(90, 100, 1),
                         Arguments.of(100, 110, 2),
                         Arguments.of(110, 120, 1),
                         Arguments.of(140, 150, 1));
    }
}
