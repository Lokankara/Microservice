package com.stack.structure.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySumTest {

    @Test
    void testSum() {
        assertEquals(0,      ArrayAssignment.sum(new double[] { }),                1e-4);
        assertEquals(-2.398, ArrayAssignment.sum(new double[] {-2.398}),           1e-4);
        assertEquals(6,      ArrayAssignment.sum(new double[] {1, 2, 3}),          1e-4);
        assertEquals(6.6,    ArrayAssignment.sum(new double[] {1.1, 2.2, 3.3}),    1e-4);
        assertEquals(9.2,    ArrayAssignment.sum(new double[] {1, 5.2, 4, 0, -1}), 1e-4);
        assertEquals(320,    ArrayAssignment.sum(new double[] {30, 89, 100, 101}), 1e-4);
    }
}
