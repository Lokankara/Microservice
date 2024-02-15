package com.stack.structure.array.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CatArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(
                        new String[]{"Grey", "Tom", "Red", "Lucky", "Jerry", "SnowBall", "Pussy", "Tabby"},
                        new String[]{"black", "white", "white", "red", "gray", "gray", "black", "white"},
                        new int[]{2, 4, 1, 3, 2, 4, 5, 1},
                        true
                ),
                Arguments.of(
                        new String[]{"Grey", "Tom", "Red", "Lucky", "Jerry", "Pussy", "Tabby"},
                        new String[]{"black", "white", "white", "red", "gray", "gray", "black", "white"},
                        new int[]{2, 4, 1, 3, 2, 4, 5, 1},
                        false
                ),
                Arguments.of(
                        new String[]{"Grey", "Tom", "Red", "Lucky", "Jerry", "SnowBall", "Pussy", "Tabby"},
                        new String[]{"black", "white", "white", "red", "gray", "gray", "black", "white"},
                        new int[]{2, 4, 1, 3, 2, 4, 1},
                        false
                ),
                Arguments.of(
                        new String[]{"Grey", "Tom", "Red", "Lucky", "Jerry", "SnowBall", "Pussy", "Tabby"},
                        new String[]{"black", "white", "white", "red", "gray", "gray", "black", "white"},
                        new int[]{2, 4, 1, 3, 2, 4, 5, 1},
                        true
                )
        );
    }
}
