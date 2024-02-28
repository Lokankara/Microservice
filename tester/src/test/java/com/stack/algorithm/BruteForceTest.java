package com.stack.algorithm;

import com.stack.algorithm.provider.Provider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class BruteForceTest {

    BruteForce bruteForce = new BruteForce();

    @Test(dataProvider = "primeNumbers", dataProviderClass = Provider.class)
    void testIsPrimeWilson(int input) {
        boolean expected = isPrime(input);
        boolean actual = bruteForce.isPrimeWilson(input);
        assertEquals(actual, expected, "For input: " + input);
    }

    @Test(dataProvider = "primeNumbers" , dataProviderClass = Provider.class)
    void testIsPrime(int input) {
        boolean expected = isPrime(input);
        boolean actual = bruteForce.isPrimeClassic(input);
        assertEquals(actual, expected, "For input: " + input);
    }

    @Test(dataProvider = "gcdTestData", dataProviderClass = Provider.class)
    public void testGCD(int a, int b, int expectedGCD) {
        int actualGCD = bruteForce.gcd(a, b);
        assertEquals(actualGCD, expectedGCD, "GCD of " + a + " and " + b);
    }

    @Test(dataProvider = "primeFactorsTestData", dataProviderClass = Provider.class)
    public void testPrimeFactors(int n, Integer[] expectedFactors) {
        List<Integer> expected = new ArrayList<>();
        List<Integer> actualFactors = bruteForce.primeFactors(n);
        Collections.addAll(expected, expectedFactors);
        assertEquals(actualFactors.toArray(), expected.toArray());
    }

    @Test(dataProvider = "divisorData", dataProviderClass = Provider.class)
    public void testCountDivisors(int n, int expectedCount) {
        int actualCount = bruteForce.countDivisors(n);
        assertEquals(actualCount, expectedCount);
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
