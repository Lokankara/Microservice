package com.stack.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class SolutionTest {

    private Solution solution;
    @BeforeEach
    public void setup() {
        solution = new Solution();
    }

    @ParameterizedTest
    @ArgumentsSource(LongestCommonPrefixProvider.class)
    void testLongestCommonPrefix(String[] input, String expected) {
        assertEquals(expected, solution.longestCommonPrefix(input));
    }

    @ParameterizedTest
    @ArgumentsSource(ProductArrayArgumentsProvider.class)
    void testProductArray(int[] numbers, long[] expected) {
        assertArrayEquals(expected, solution.productArray(numbers));
    }

    @ParameterizedTest
    @ArgumentsSource(ProductArrayArgumentsProvider.class)
    void testProductArrayTimeoutPreemptively(int[] numbers, long[] expected) {
        assertTimeoutPreemptively(
                Duration.ofNanos(50000000), () -> assertArrayEquals(
                        expected, solution.productArray(numbers)));

    }

    @ParameterizedTest
    @ArgumentsSource(IsMatchArgumentsProvider.class)
    void testIsMatch(String s, String p, boolean expected) {
        assertEquals(expected, solution.isMatch(s, p));
    }
}
