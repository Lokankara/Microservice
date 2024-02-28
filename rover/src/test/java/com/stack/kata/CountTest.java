package com.stack.kata;

import com.stack.kata.provider.StringPairsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountTest {

    @ParameterizedTest
    @ArgumentsSource(StringPairsProvider.class)
    void testGetSumFromString(String a, String b, double expectedSum) {
        Count count = new Count();
        double actualSum = count.getSumFromString(a, b);
        assertEquals(expectedSum, actualSum);
    }
}
