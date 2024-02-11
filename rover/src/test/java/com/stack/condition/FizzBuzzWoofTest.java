package com.stack.condition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static com.stack.condition.FizzBuzzWoof.fizzBuzz;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzWoofTest {

    @Test
    void testFizzBuzz() {
        String fizzed = fizzBuzz(1, 34, 1);
        String expected = "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, Fizz Buzz, 16, 17, Fizz, 19, Buzz, Fizz, 22, 23, Fizz, Buzz, 26, Fizz, 28, 29, Fizz Buzz, 31, 32, Fizz";
        assertEquals(expected, fizzed);
    }

    @Test
    void testFizzBuzzWoof() {
        String expected = "1, 2, Fizz Fizz (3), 4, Buzz Buzz (5), Fizz (6), Woof Woof (7), 8, Fizz (9), Buzz (10), 11, Fizz (12), Fizz (13), Woof (14), Fizz Buzz Buzz (15), 16, Woof (17), Fizz (18), 19, Buzz (20), Fizz Woof (21), 22, Fizz (23), Fizz (24), Buzz Buzz (25), 26, Fizz Woof (27), Woof (28), 29, Fizz Fizz Buzz (30), Fizz (31), Fizz (32), Fizz Fizz Fizz (33)";
        String result = new FizzBuzzWoof().fizzBuzzWoof(1, 33, 1);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ArgumentsSource(FizzBuzzWoofArgumentsProvider.class)
    void testFizzBuzzWoofDynamic(int start, int end, int step, String expected) {
        String result = new FizzBuzzWoof().fizzBuzzWoof(start, end, step);
        assertEquals(expected, result);
    }
}
