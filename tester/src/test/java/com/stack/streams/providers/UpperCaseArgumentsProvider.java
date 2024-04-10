package com.stack.streams.providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class UpperCaseArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(Arrays.asList("apple", "banana", "orange", "grape"), Arrays.asList("APPLE", "BANANA", "ORANGE", "GRAPE")),
                Arguments.of(Arrays.asList("cat", "dog", "fish", "bird"), Arrays.asList("CAT", "DOG", "FISH", "BIRD")),
                Arguments.of(Arrays.asList("one", "two", "three", "four"), Arrays.asList("ONE", "TWO", "THREE", "FOUR")),
                Arguments.of(Arrays.asList("Java", "Python", "JavaScript", "C++"), Arrays.asList("JAVA", "PYTHON", "JAVASCRIPT", "C++")),
                Arguments.of(Arrays.asList("apple", "banana", "orange", "grape", "kiwi"), Arrays.asList("APPLE", "BANANA", "ORANGE", "GRAPE", "KIWI")),
                Arguments.of(Arrays.asList("Lion", "Tiger", "Elephant", "Giraffe"), Arrays.asList("LION", "TIGER", "ELEPHANT", "GIRAFFE")),
                Arguments.of(Arrays.asList("apple", "banana", "orange", "grape", "pineapple"), Arrays.asList("APPLE", "BANANA", "ORANGE", "GRAPE", "PINEAPPLE")),
                Arguments.of(Arrays.asList("apple", "banana", "orange", "grape", "watermelon"), Arrays.asList("APPLE", "BANANA", "ORANGE", "GRAPE", "WATERMELON")),
                Arguments.of(Arrays.asList("apple", "banana", "orange", "grape", "mango"), Arrays.asList("APPLE", "BANANA", "ORANGE", "GRAPE", "MANGO")),
                Arguments.of(Arrays.asList("red", "green", "blue", "yellow",
                                           "orange"), Arrays.asList("RED", "GREEN", "BLUE", "YELLOW", "ORANGE")),
                Arguments.of(Arrays.asList("apple", "banana", "orange", "grape"),
                             Arrays.asList("APPLE", "BANANA", "ORANGE", "GRAPE")),
                Arguments.of(Arrays.asList("cat", "dog", "bird", "fish"),
                             Arrays.asList("CAT", "DOG", "BIRD", "FISH")),
                Arguments.of(Arrays.asList("elephant", "lion", "tiger", "zebra"),
                             Arrays.asList("ELEPHANT", "LION", "TIGER", "ZEBRA")),
                Arguments.of(Arrays.asList("apple", "APPLE", "ApPlE", "aPpLe"),
                             Arrays.asList("APPLE", "APPLE", "APPLE", "APPLE")),
                Arguments.of(Arrays.asList("1", "2", "3", "4"),
                             Arrays.asList("1", "2", "3", "4")),
                Arguments.of(Arrays.asList("Hello", "WORLD", "123", "???"),
                             Arrays.asList("HELLO", "WORLD", "123", "???")),
                Arguments.of(Arrays.asList("", "", "", ""),
                             Arrays.asList("", "", "", "")),
                Arguments.of(Arrays.asList("one", "Two", "THRee", "FOUr"),
                             Arrays.asList("ONE", "TWO", "THREE", "FOUR")),
                Arguments.of(Arrays.asList("Java", "is", "FUN", "!"),
                             Arrays.asList("JAVA", "IS", "FUN", "!")),
                Arguments.of(Arrays.asList("a", "b", "c", "d"),
                             Arrays.asList("A", "B", "C", "D"))
        );
    }
}
