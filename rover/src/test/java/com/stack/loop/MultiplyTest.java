package com.stack.loop;

import com.stack.loop.provider.MultiplyArgumentsProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MultiplyTest {

    @Test
    void test() {
        for (int i = 0, r; (r = i * 3) < 101; i++) {
            System.out.printf("%s ", r);
        }
    }

    @Test
    void multiByThreeTest() {
        int[] actual = new Multiply().multiByThree();
        int[] expected = getMultiByThree();
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(actual, expected);
    }

    @Test
    void multiByThreeWhile() {
        int[] actual = new Multiply().multiByThreeWhile();
        int[] expected = getMultiByThree();
        assertArrayEquals(actual, expected);
    }

    @ParameterizedTest
    @ArgumentsSource(MultiplyArgumentsProvider.class)
    void testMultiBy(
            int start,
            int end,
            int step,
            int[] expected) {
        int[] actual = new Multiply().multiBy(start, end, step);
        assertArrayEquals(expected, actual);
    }

    private int[] getMultiByThree() {
        return IntStream.range(0, 33)
                        .map(i -> (i + 1) * 3)
                        .toArray();
    }

}
