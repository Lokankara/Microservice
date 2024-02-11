package com.stack.structure.string.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class SubstringIndexFinderArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of("Посмотрите как Рите нравится ритм", "рит", new int[]{6, 15, 29}),
                Arguments.of("The quick brown fox jumps over the lazy dog", "the", new int[]{0, 31})
        );
    }
}
