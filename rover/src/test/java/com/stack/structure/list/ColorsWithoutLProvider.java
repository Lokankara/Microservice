package com.stack.structure.list;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ColorsWithoutLProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context)
            throws Exception {
        return Stream.of(
                Arguments.of(Arrays.asList("Tan", "Orange", "Pink")),
                Arguments.of(Arrays.asList("Yellow", "Orange", "Pink", "Purple")),
                Arguments.of(List.of())
        );
    }
}
