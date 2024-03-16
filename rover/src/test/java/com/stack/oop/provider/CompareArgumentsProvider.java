package com.stack.oop.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CompareArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(10, 20, -1),
                         Arguments.of(20, 10, 1),
                         Arguments.of(15, 15, 0),
                         Arguments.of(0, 0, 0),
                         Arguments.of(-5, -10, 1),
                         Arguments.of(1, -1, 1),
                         Arguments.of(1, 2, -1),
                         Arguments.of(3.5, 2.7, 1),
                         Arguments.of(10L, 5L, 1),
                         Arguments.of(5.6f, 3.2f, 1),
                         Arguments.of((short) 51251, (short) 123123131, 1),
                         Arguments.of((byte) -11, (byte) -1, -1),
                         Arguments.of((short) 5121251, (short) 1231, 1),
                         Arguments.of((short) -1251, (short) -1231, -1),
                         Arguments.of((short) 51, (short) 131, -1),
                         Arguments.of((byte) 127, (byte) 126, 1),
                         Arguments.of((byte) 255, (byte) 256, -1),
                         Arguments.of((byte) 280, (byte) -280, 1));
    }
}
