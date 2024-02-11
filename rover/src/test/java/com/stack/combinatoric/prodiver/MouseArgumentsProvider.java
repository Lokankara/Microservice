package com.stack.combinatoric.prodiver;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class MouseArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(Arguments.of("2 3 3 2 4 1 5 1", "RRF"),
                         Arguments.of("3 3 1 2 3 4 5 6 7 8 9", "RFFR"),
                         Arguments.of("1 1 1", ""),
                         Arguments.of("2 2 1 2 3 4", "RF"),
                         Arguments.of("2 2 4 3 2 1", "RF"),
                         Arguments.of("4 1 4 3 2 1", "FFF"));
    }
}
