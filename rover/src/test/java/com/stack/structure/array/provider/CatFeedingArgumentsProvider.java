package com.stack.structure.array.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CatFeedingArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        String error = "Something went wrong...";
        return Stream.of(
                Arguments.of(
                        new String[]{"Grey", "Tom", "Red", "Lucky", "Jerry", "SnowBall", "Pussy", "Tabby"},
                        new String[]{"black", "white", "white", "red", "gray", "red", "black", "white"},
                        new double[]{1, 11.5, 23, 11.0, 21, 11, 8, 7, 11.0, 10.0, 2, 4, 1, 3, 2, 4, 5},
                        new String[]{error, error, error, "Cat Jerry fed at 11am", error,
                                "Cat Jerry fed at 11am", error, error, "Cat Jerry fed at 11am",
                                error, error, error, error, error, error, error, error}
                )
        );
    }
}
