package com.stack.algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlgorithmTest {

    Algorithm algorithm = new Algorithm();

    @ParameterizedTest
    @ArgumentsSource(PrimeArgumentsProvider.class)
    void testIsPrimeWilson(int input) {
        boolean expected = isPrime(input);
        boolean actual = algorithm.isPrimeWilson(input);
        assertEquals(expected, actual, "For input: " + input);
    }

    @ParameterizedTest
    @ArgumentsSource(PrimeArgumentsProvider.class)
    void testIsPrime(int input) {
        boolean expected = isPrime(input);
        boolean actual = algorithm.isPrime(input);
        assertEquals(expected, actual, "For input: " + input);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

}
