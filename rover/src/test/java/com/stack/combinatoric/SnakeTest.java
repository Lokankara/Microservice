package com.stack.combinatoric;

import com.stack.combinatoric.prodiver.MatrixArgumentsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SnakeTest {

    @ParameterizedTest
    @ArgumentsSource(MatrixArgumentsProvider.class)
    void testBypassMatrix(int n, int[][] expected) {
        int[][] result = new Snake().bypassMatrix(n);
        assertArrayEquals(expected, result);
    }
}
