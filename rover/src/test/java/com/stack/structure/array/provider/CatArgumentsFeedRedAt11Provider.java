package com.stack.structure.array.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CatArgumentsFeedRedAt11Provider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        String[] cats = {"Grey", "Tom", "Red", "Lucky", "Jerry", "Red", "Pussy", "Red"};
        double[] hours = {1, 11.5, 23, 11.0, 21, 11, 8, 7};
        boolean[][] expectedFeed = new boolean[cats.length][hours.length];

        for (int i = 0; i < cats.length; i++) {
            for (int j = 0; j < hours.length; j++) {
                expectedFeed[i][j] = cats[i].equals("Red") && hours[j] == 11.0;
            }
        }
        return Stream.of(Arguments.of(cats, hours, expectedFeed));
    }
}
