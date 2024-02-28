package com.stack.kata.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class StringPairsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of("abc 123 def 456", "xyz 789 uvw -321", 1047.0),
                Arguments.of("1.5 is not 2.5", "3.5 but 4.5", 12.0),
                Arguments.of("1.23", "4.56", 5.79),
                Arguments.of("", "", 0.0)
        );
    }
}
