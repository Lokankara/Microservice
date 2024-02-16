package com.stack.structure.array.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CatColorArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new String[]{"black", "white", "black", "gray"}, new boolean[]{true, false, true, false}),
                Arguments.of(new String[]{"white", "black", "gray"}, new boolean[]{false, true, false}),
                Arguments.of(new String[]{"black", "black", "black"}, new boolean[]{true, true, true}),
                Arguments.of(new String[]{"white", "white", "white"}, new boolean[]{false, false, false})
        );
    }
}
