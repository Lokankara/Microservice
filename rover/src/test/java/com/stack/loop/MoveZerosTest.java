package com.stack.loop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoveZerosTest {
    @Test
    void testMoveZeros() {
        MoveZeros zeros = new MoveZeros();
        int[] arr = new int[]{0, 1, 0, 3, 12};
        int[] expected = new int[]{1, 3, 12, 0, 0};
        assertArrayEquals(expected, zeros.moveZeros(arr));
    }

    @Test
    void testMoveZerosWithEmptyArray() {
        MoveZeros zeros = new MoveZeros();
        int[] arr = new int[]{};
        int[] expected = new int[]{};
        assertArrayEquals(expected, zeros.moveZeros(arr));
    }

    @Test
     void testMoveZerosWithAllZeros() {
        MoveZeros zeros = new MoveZeros();
        int[] arr = new int[]{0, 0, 0, 0, 0};
        int[] expected = new int[]{0, 0, 0, 0, 0};
        assertArrayEquals(expected, zeros.moveZeros(arr));
    }
}
