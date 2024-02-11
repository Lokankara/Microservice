package com.stack.condition;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class FizzBuzzWoofArgumentsProvider
        implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(29, 48, 1,
                             "29, Fizz Fizz Buzz (30), Fizz (31), Fizz (32), Fizz Fizz Fizz (33), Fizz (34), Fizz Buzz Buzz Woof (35), Fizz Fizz (36), Fizz Woof (37), Fizz (38), Fizz Fizz (39), Buzz (40), 41, Fizz Woof (42), Fizz (43), 44, Fizz Buzz Buzz (45), 46, Woof (47), Fizz (48)"),
                Arguments.of(70, 87, 1,
                             "Buzz Woof Woof (70), Woof (71), Fizz Woof (72), Fizz Woof (73), Woof (74), Fizz Buzz Buzz Woof (75), Woof (76), Woof Woof Woof (77), Fizz Woof (78), Woof (79), Buzz (80), Fizz (81), 82, Fizz (83), Fizz Woof (84), Buzz Buzz (85), 86, Fizz Woof (87)"),
                Arguments.of(52, 70, 1,
                             "Buzz (52), Fizz Buzz (53), Fizz Buzz (54), Buzz Buzz Buzz (55), Buzz Woof (56), Fizz Buzz Woof (57), Buzz (58), Buzz (59), Fizz Buzz (60), 61, 62, Fizz Fizz Woof (63), 64, Buzz Buzz (65), Fizz (66), Woof (67), 68, Fizz (69), Buzz Woof Woof (70)")
        );
    }
}
