package com.stack.structure.string.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CharExtractorArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext)
            throws Exception {
        return Stream.of(
                Arguments.of('о', "Перестановочный алгоритм быстрого действия", "ооооо"),
                Arguments.of('a', "The quick brown fox jumps over the lazy dog", "a"));
    }
}
