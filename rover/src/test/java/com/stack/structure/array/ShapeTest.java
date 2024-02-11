package com.stack.structure.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    private Shape shape;

    @BeforeEach
    void setUp() {
        shape = new Shape();
    }

    @Test
    void testLeftDownQuadrantSize10() {
        int[][] expected = {
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                {0, 1, 2, 3, 4, 5, 6, 7, 8},
                {0, 1, 2, 3, 4, 5, 6, 7},
                {0, 1, 2, 3, 4, 5, 6},
                {0, 1, 2, 3, 4, 5},
                {0, 1, 2, 3, 4},
                {0, 1, 2, 3},
                {0, 1, 2},
                {0, 1},
                {0}
        };
        int[][] actual = shape.leftDownQuadrant(10);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testOffsetTriangleSize10() {
        String[][] expected = {
                {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"},
                {" ", "0", "1", "2", "3", "4", "5", "6", "7", "8"},
                {" ", " ", "0", "1", "2", "3", "4", "5", "6", "7"},
                {" ", " ", " ", "0", "1", "2", "3", "4", "5", "6"},
                {" ", " ", " ", " ", "0", "1", "2", "3", "4", "5"},
                {" ", " ", " ", " ", " ", "0", "1", "2", "3", "4"},
                {" ", " ", " ", " ", " ", " ", "0", "1", "2", "3"},
                {" ", " ", " ", " ", " ", " ", " ", "0", "1", "2"},
                {" ", " ", " ", " ", " ", " ", " ", " ", "0", "1"},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", "0"}
        };
        String[][] actual = shape.offsetTriangle(10);
        assertArrayEquals(expected, actual);
    }


    @Test
    void testOffsetPyramidSize10() {
        String[][] expected = {
                {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"},
                {" ", "8", "7", "6", "5", "4", "3", "2", "1", "0", "1", "2", "3", "4", "5", "6", "7", "8", " "},
                {" ", " ", "7", "6", "5", "4", "3", "2", "1", "0", "1", "2", "3", "4", "5", "6", "7", " ", " "},
                {" ", " ", " ", "6", "5", "4", "3", "2", "1", "0", "1", "2", "3", "4", "5", "6", " ", " ", " "},
                {" ", " ", " ", " ", "5", "4", "3", "2", "1", "0", "1", "2", "3", "4", "5", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", "4", "3", "2", "1", "0", "1", "2", "3", "4", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", "3", "2", "1", "0", "1", "2", "3", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", "2", "1", "0", "1", "2", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", "1", "0", "1", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", "0", " ", " ", " ", " ", " ", " ", " ", " ", " "}
        };
        String[][] actual = shape.offsetPyramid(10);
        print2DArray(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testOffsetPyramid() {
        String[][] expected = {
                {" ", " ", " ", " ", "0", " ", " ", " ", " "},
                {" ", " ", " ", "1", "0", "1", " ", " ", " "},
                {" ", " ", "2", "1", "0", "1", "2", " ", " "},
                {" ", "3", "2", "1", "0", "1", "2", "3", " "},
                {"4", "3", "2", "1", "0", "1", "2", "3", "4"}
        };
        String[][] actual = shape.offsetPyramidUp(5);
        print2DArray(actual);
        assertTrue(Arrays.deepEquals(expected, actual));
        assertArrayEquals(expected, actual);
    }

    @Test
    void testOffsetPyramidDownTest() {
        String[][] expected = {
                {"4", "3", "2", "1", "0", "1", "2", "3", "4"},
                {" ", "3", "2", "1", "0", "1", "2", "3", " "},
                {" ", " ", "2", "1", "0", "1", "2", " ", " "},
                {" ", " ", " ", "1", "0", "1", " ", " ", " "},
                {" ", " ", " ", " ", "0", " ", " ", " ", " "}
        };
        String[][] actual = shape.offsetPyramid(5);
        print2DArray(actual);
        assertTrue(Arrays.deepEquals(expected, actual));
        assertArrayEquals(expected, actual);
    }

    private void print2DArray(String[][] array) {
        Arrays.stream(array)
              .map(row -> String.join(" ", row))
              .forEach(System.out::println);
    }
}
