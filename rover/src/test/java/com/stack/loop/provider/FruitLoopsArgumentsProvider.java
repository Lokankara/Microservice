package com.stack.loop.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class FruitLoopsArgumentsProvider
        implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(new int[]{237, 263, 252, 248, 253, 247}, false),
                         Arguments.of(new int[]{235, 265, 240, 260, 245, 255}, false),
                         Arguments.of(new int[]{230, 270, 235, 265, 240, 260}, false),
                         Arguments.of(new int[]{225, 275, 230, 270, 235, 265}, false),
                         Arguments.of(new int[]{220, 280, 225, 275, 230, 270}, false),
                         Arguments.of(new int[]{215, 285, 220, 280, 225, 275}, false),
                         Arguments.of(new int[]{210, 290, 215, 285, 220, 280}, false),
                         Arguments.of(new int[]{205, 295, 210, 290, 215, 285}, false),
                         Arguments.of(new int[]{200, 300, 205, 295, 210, 290}, false),
                         Arguments.of(new int[]{195, 305, 200, 300, 205, 295}, false),
                         Arguments.of(new int[]{190, 310, 195, 305, 200, 300}, false),
                         Arguments.of(new int[]{185, 315, 190, 310, 195, 305}, false),
                         Arguments.of(new int[]{180, 320, 185, 315, 190, 310}, false),
                         Arguments.of(new int[]{175, 325, 180, 320, 185, 315}, false),
                         Arguments.of(new int[]{236, 263, 252, 248, 253, 247}, false),
                         Arguments.of(new int[]{236, 263, 240, 260, 245, 255}, false),
                         Arguments.of(new int[]{240, 260, 236, 263, 240, 260}, false),
                         Arguments.of(new int[]{245, 255, 240, 260, 236, 263}, false),
                         Arguments.of(new int[]{236, 263, 240, 260, 245, 255}, false),
                         Arguments.of(new int[]{240, 260, 236, 263, 240, 260}, false),
                         Arguments.of(new int[]{245, 255, 240, 260, 236, 263}, false),
                         Arguments.of(new int[]{236, 263, 240, 260, 245, 255}, false),
                         Arguments.of(new int[]{240, 260, 236, 263, 240, 260}, false),
                         Arguments.of(new int[]{245, 255, 240, 260, 239, 263}, false),
                         Arguments.of(new int[]{239, 263, 240, 260, 248, 255}, false),
                         Arguments.of(new int[]{240, 260, 245, 255, 250, 250}, true),
                         Arguments.of(new int[]{240, 260, 245, 255, 250, 250}, true),
                         Arguments.of(new int[]{240, 260, 245, 255, 240, 260}, true),
                         Arguments.of(new int[]{240, 260, 245, 255, 240, 260}, true),
                         Arguments.of(new int[]{240, 260, 245, 255, 240, 260}, true),
                         Arguments.of(new int[]{250, 250, 250, 250, 250, 250}, true)
                         );
    }
}
