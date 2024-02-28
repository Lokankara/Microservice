package com.stack.oop.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ArrayInfoArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(new String[]{"3", "7", "2", "9", "5"}, "Min: 2, max: 9, amount: 26"),
                         Arguments.of(new String[]{"0", "0", "0", "0"}, "Min: 0, max: 0, amount: 0"),
                         Arguments.of(new String[]{"-5", "5", "10", "-10"}, "Min: -10, max: 10, amount: 0"),
                         Arguments.of(new String[]{"-1", "+1"}, "Min: -1, max: 1, amount: 0"),
                         Arguments.of(new String[]{"10", "20", "30"}, "Min: 10, max: 30, amount: 60"));
    }
}
