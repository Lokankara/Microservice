package com.stack.streams.providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class SortReverseArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext)
            throws Exception {
        return Stream.of(
                Arguments.of(Arrays.asList("apple", "banana", "orange", "grape"),
                             Arrays.asList("orange", "grape", "banana", "apple")),
                Arguments.of(Arrays.asList("cat", "dog", "bird", "fish"),
                             Arrays.asList("fish", "dog", "cat", "bird")),
                Arguments.of(Arrays.asList("elephant", "lion", "tiger", "zebra"),
                             Arrays.asList("zebra", "tiger", "lion", "elephant")),
                Arguments.of(Arrays.asList("apple", "APPLE", "ApPlE", "aPpLe"),
                             Arrays.asList("apple", "aPpLe", "ApPlE", "APPLE")),
                Arguments.of(Arrays.asList("1", "2", "3", "4"),
                             Arrays.asList("4", "3", "2", "1")),
                Arguments.of(Arrays.asList("Hello", "WORLD", "123", "???"),
                             Arrays.asList("WORLD", "Hello", "???", "123")),
                Arguments.of(Arrays.asList("", "", "", ""),
                             Arrays.asList("", "", "", "")),
                Arguments.of(Arrays.asList("one", "Two", "THRee", "FOUr"),
                             Arrays.asList("one", "Two", "THRee", "FOUr")),
                Arguments.of(Arrays.asList("Java", "is", "FUN", "!"),
                             Arrays.asList("is", "Java", "FUN", "!")),
                Arguments.of(Arrays.asList("a", "b", "c", "d"),
                             Arrays.asList("d", "c", "b", "a"))
        );
    }
}
