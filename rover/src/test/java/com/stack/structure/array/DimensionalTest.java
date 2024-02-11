package com.stack.structure.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DimensionalTest {

    @Test
    void testGet4D() {
        int[][][][] sampleArray =
                {{{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}}, {{{9, 10}, {11, 12}}, {{13, 14}, {15, 16}}}};
        String expected = "1\t2\t3\t4\t\n5\t6\t7\t8\t\n9\t10\t11\t12\t\n13\t14\t15\t16\t\n";
        String result = new Dimensional().get4D(sampleArray);
        assertEquals(expected, result);
    }
}
