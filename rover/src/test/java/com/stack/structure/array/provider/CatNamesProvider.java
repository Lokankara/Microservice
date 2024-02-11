package com.stack.structure.array.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CatNamesProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(new String[]{"Grey", "Black", "Tom", "Lucky", "Jerry", "SnowBall", "Puss", "Tabby"},
                                      new char[]{'B', 'L'},
                                      new String[]{"Black", "Lucky"}));
    }
}
