package com.stack.structure.list;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ColorsWithLProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(Arrays.asList("White", "Lemon", "Yellow", "Orange", "Red", "Pink", "Purple", "Blue"),
                             Arrays.asList("White", "Yellow", "Orange", "Red", "Pink", "Purple", "Blue")),
                Arguments.of(Arrays.asList("Yellow", "Blue", "Lemon"), Arrays.asList("Yellow", "Blue")),
                Arguments.of(Arrays.asList("White", "Tan", "Orange", "Pink", "Lime", "Lemon"),
                             Arrays.asList("White", "Tan", "Orange", "Pink")),
                Arguments.of(Arrays.asList("Lime", "Lemon"), List.of())
        );
    }
}
