package com.stack.loop;

import com.stack.loop.provider.FruitLoopsArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FruitLoopsTest {

    private FruitLoops tester;
    @BeforeEach
    void setUp() {
        tester = new FruitLoops();
    }

    @ParameterizedTest
    @ArgumentsSource(FruitLoopsArgumentsProvider.class)
    void runTest(int[] box, boolean expected) {
        assertEquals(expected, tester.checkFruit(box));
    }

    @ParameterizedTest
    @ArgumentsSource(FruitLoopsArgumentsProvider.class)
    void testFruitLoops(int[] box, boolean expected) {
        assertEquals(expected, tester.checkBox(box));
    }
}
