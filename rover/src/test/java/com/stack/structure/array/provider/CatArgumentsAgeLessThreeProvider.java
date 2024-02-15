package com.stack.structure.array.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CatArgumentsAgeLessThreeProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(new String[]{"Grey", "Tom", "Red", "Lucky", "Jerry", "SnowBall", "Pussy", "Tabby"}, new int[]{2, 5, 3, 1, 4, 2, 3, 6}, new String[]{"Grey", "Lucky", "SnowBall"}),
                Arguments.of(new String[]{"Spot", "Stripe", "Paws", "Claws", "Whiskers", "Simba", "Scaredy", "Sneaky"}, new int[]{3, 1, 6, 2, 4, 3, 5, 1}, new String[]{"Stripe", "Claws", "Sneaky"}),
                Arguments.of(new String[]{}, new int[]{}, new String[]{}),
                Arguments.of(null, new int[0], new String[]{}),
                Arguments.of(new String[]{"Jerry", "SnowBall", "Pussy", "Tabby"}, new int[]{4, 2, 3, 6}, new String[]{"SnowBall"}),
                Arguments.of(new String[]{"Mittens", "Fluffy", "Whiskers"}, new int[]{1, 2, 3}, new String[]{"Mittens", "Fluffy"}),
                Arguments.of(new String[]{"Garfield", "Odie"}, new int[]{5, 6}, new String[]{}),
                Arguments.of(new String[]{}, new int[]{}, new String[]{}),
                Arguments.of(null, new int[]{1, 2, 3}, new String[]{}),
                Arguments.of(new String[]{"Kitty", "Felix", "Sylvester"}, new int[]{2, 3, 4}, new String[]{"Kitty"})
        );
    }
}
