package com.stack.combinatoric;

import com.stack.combinatoric.prodiver.MirrorPrimeArgumentsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MirrorPrimeTest {

    @ParameterizedTest(name = "range[{0}, {1}] = count:{2}")
    @ArgumentsSource(MirrorPrimeArgumentsProvider.class)
    void testMirrorPrimesCount(int a, int b, int expectedCount) {
        int actualCount = new MirrorPrime().countMirrorPrimes(a, b);
        assertEquals(expectedCount, actualCount);
    }
}
