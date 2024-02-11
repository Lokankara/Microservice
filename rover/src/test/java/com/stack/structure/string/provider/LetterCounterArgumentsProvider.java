package com.stack.structure.string.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class LetterCounterArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of('е', "Перевыборы выбранного президента", 4),
                Arguments.of('o', "The quick brown fox jumps over the lazy dog", 4)
        );
    }
}
