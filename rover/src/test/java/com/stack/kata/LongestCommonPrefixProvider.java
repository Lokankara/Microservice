package com.stack.kata;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class LongestCommonPrefixProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"dog", "race", "car"}, ""),
                Arguments.of(new String[]{"apple", "ape", "apricot"}, "ap"),
                Arguments.of(new String[]{"", "", ""}, ""),
                Arguments.of(new String[]{"", "abc", ""}, ""),
                Arguments.of(new String[]{"abc", "abc", "abc"}, "abc")
        );
    }
}

