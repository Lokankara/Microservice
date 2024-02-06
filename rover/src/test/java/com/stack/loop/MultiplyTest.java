package com.stack.loop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MultiplyTest {

    @Test
    void multiByThreeTest() {
        int[] multiByThree = new Multiply().multiByThree();
        int[] expected = getMultiByThree();
        assertArrayEquals(multiByThree, expected);
    }

    @Test
    void multiByThreeWhile() {
        int[] multiByThreeWhile = new Multiply().multiByThreeWhile();
        int[] expected = getMultiByThree();
        assertArrayEquals(multiByThreeWhile, expected);
    }


    private int[] getMultiByThree() {
        int[] expected = new int[33];
        for (int i = 0; i < 33; i++) {
            expected[i] = (i + 1) * 3;
        }
        return expected;
    }

    @Test
    void testMultiBy() {
        Multiply multi = new Multiply();
        int[] result1 = multi.multiBy(0, 10, 2);
        assertArrayEquals(new int[]{0, 2, 4, 6, 8}, result1);
        int[] result2 = multi.multiBy(1, 11, 3);
        assertArrayEquals(new int[]{3, 6, 9}, result2);
        int[] result3 = multi.multiBy(10, 30, 5);
        assertArrayEquals(new int[]{10, 15, 20, 25}, result3);
        int[] result4 = multi.multiBy(5, 20, 7);
        assertArrayEquals(new int[]{7, 14}, result4);
    }
}
