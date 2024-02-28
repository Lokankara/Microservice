package com.stack.oop.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class PriceErrorArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context)
            throws Exception {
        return Stream.of(Arguments.of("invalidCoin"),
                         Arguments.of(""),
                         Arguments.of(" "),
                         Arguments.of((String) null),
                         Arguments.of("asd"),
                         Arguments.of("=1231"),
                         Arguments.of("++1231"),
                         Arguments.of("--1231"),
                         Arguments.of("1231!"),
                         Arguments.of("asd1231"),
                         Arguments.of("--"),
                         Arguments.of("!"),
                         Arguments.of("_"),
                         Arguments.of("+"),
                         Arguments.of("-"),
                         Arguments.of("!0"),
                         Arguments.of("$"),
                         Arguments.of("#"),
                         Arguments.of("~"),
                         Arguments.of("*"),
                         Arguments.of("()[]{}"),
                         Arguments.of("asd1231"),
                         Arguments.of("21312asd"));
    }
}
