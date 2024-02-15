package com.stack.structure.array.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CatArgumentsNamesProvider
        implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(new String[]{"Grey", "Tom", "Red", "Lucky"}, new String[]{"Lucky", "Red", "Tom", "Grey"}),
                Arguments.of(new String[]{"Jerry", "SnowBall", "Pussy", "Tabby"}, new String[]{"Tabby", "Pussy", "SnowBall", "Jerry"}),
                Arguments.of(new String[]{"Mittens", "Fluffy", "Whiskers"}, new String[]{"Whiskers", "Fluffy", "Mittens"}),
                Arguments.of(new String[]{"Spot", "Stripe", "Paws"}, new String[]{"Paws", "Stripe", "Spot"}),
                Arguments.of(new String[]{"Garfield", "Odie"}, new String[]{"Odie", "Garfield"}),
                Arguments.of(new String[]{"Tom"}, new String[]{"Tom"}),
                Arguments.of(new String[]{}, new String[]{}),
                Arguments.of(null, new String[]{})
        );
    }
}
