package com.stack.e2e;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class WordsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(
                        List.of("car", "bat", "elephant", "frog", "cow", "cat"),
                        Map.of('c', "car", 'b', "bat", 'e', "elephant", 'f', "frog")
                ),
                Arguments.of(
                        List.of("zoo", "zebra", "ant", "alligator", "ax", "art"),
                        Map.of('z', "zebra", 'a', "alligator")
                ),
                Arguments.of(
                        List.of("apple", "ant", "alligator", "ape"),
                        Map.of('a', "alligator")
                )
        );
    }
}
