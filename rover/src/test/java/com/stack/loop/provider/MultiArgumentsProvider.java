package com.stack.loop.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class MultiArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(6, 9, 5, new String[]{"None"}),
                Arguments.of(1, 4, 5, new String[]{"None"}),
                Arguments.of(21, 22, 5, new String[]{"None"}),
                Arguments.of(21, 25, 5, new String[]{"None"}),
                Arguments.of(-19, -15, 5, new String[]{"None"}),
                Arguments.of(0, 4, 5, new String[]{"0"}),
                Arguments.of(5, 10, 5, new String[]{"5"}),
                Arguments.of(21, 26, 5, new String[]{"25"}),
                Arguments.of(19, 21, 5, new String[]{"20"}),
                Arguments.of(-9, -4, 5, new String[]{"-5"}),
                Arguments.of(-21, -19, 5, new String[]{"-20"}),
                Arguments.of(-6, 1, 5, new String[]{"-5", "0"}),
                Arguments.of(4, 11, 5, new String[]{"5", "10"}),
                Arguments.of(9, 16, 5, new String[]{"10", "15"}),
                Arguments.of(9, 15, 5, new String[]{"10"}),
                Arguments.of(6, 15, 5, new String[]{"10"}),
                Arguments.of(20, 30, 5, new String[]{"20", "25"}),
                Arguments.of(-10, -4, 5, new String[]{"-10", "-5"}),
                Arguments.of(4, 16, 5, new String[]{"5", "10", "15"}),
                Arguments.of(11, 27, 5, new String[]{"15", "20", "25"}),
                Arguments.of(11, 26, 5, new String[]{"15", "20", "25"}),
                Arguments.of(-11, 1, 5, new String[]{"-10", "-5", "0"}),
                Arguments.of(-15, 0, 5, new String[]{"-15", "-10", "-5"}),
                Arguments.of(-16, -1, 5, new String[]{"-15", "-10", "-5"}),
                Arguments.of(-10, 10, 5, new String[]{"-10", "-5", "0", "5"}),
                Arguments.of(11, 50, 5, new String[]{"15", "20", "25", "30", "35", "40", "45"}),
                Arguments.of(-20, 20, 5, new String[]{"-20", "-15", "-10", "-5", "0", "5", "10", "15"})
        );
    }
}
