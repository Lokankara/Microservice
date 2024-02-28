package com.stack.oop.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class PriceArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of("5", "The cost of the goods is 5.00 coins"),
                         Arguments.of("15", "The cost of the goods is 15.00 coins"),
                         Arguments.of("+5", "The cost of the goods is +5.00 coins"),
                         Arguments.of("0", "Invalid data"),
                         Arguments.of("101", "Invalid data"),
                         Arguments.of("-1", "Invalid data"));
    }
}
