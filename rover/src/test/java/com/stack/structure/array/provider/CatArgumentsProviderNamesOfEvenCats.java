package com.stack.structure.array.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CatArgumentsProviderNamesOfEvenCats
        implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(new String[]{"Grey", "Tom", "Red", "Lucky"}, new String[]{"Grey", "Red"}),
                Arguments.of(new String[]{"Tom", "Red", "Lucky"}, new String[]{"Tom", "Lucky"}),
                Arguments.of(new String[]{"Red", "Lucky"}, new String[]{"Red"}),
                Arguments.of(new String[]{"Jerry", "SnowBall", "Pussy", "Tabby", "Mittens" }, new String[]{"Jerry", "Pussy", "Mittens"}),
                Arguments.of(new String[]{"Alice", "Bob", "Charlie", "Dave", "Eve", "Frank"}, new String[]{"Alice", "Charlie", "Eve"}),
                Arguments.of(new String[]{"Mittens"}, new String[]{"Mittens"}),
                Arguments.of(new String[]{"Spot", "Stripe", "Paws", "Claws", "Whiskers", "Simba", "Scaredy", "Sneaky"}, new String[]{"Spot", "Paws", "Whiskers", "Scaredy"}),
                Arguments.of(new String[]{}, new String[]{}),
                Arguments.of(null, new String[0])
        );
    }
}
