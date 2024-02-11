package com.stack.structure.array;

import com.stack.structure.array.provider.MatrixSumArgumentsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MatrixSumTest {

    @ParameterizedTest
    @ArgumentsSource(MatrixSumArgumentsProvider.class)
    void testMatrixSum(int n, int m, String lines, int[][] expected) {
        int[][] sums = new MatrixSum().sum(n, m, lines);
        print2DArray(sums);
        assertArrayEquals(expected, sums);
    }
    private static void print2DArray(int[][] array) {
        Arrays.stream(array).map(
                row -> String.join(" ",
                        Arrays.stream(row)
                              .mapToObj(String::valueOf)
                              .toArray(String[]::new)))
              .forEach(System.out::println);
    }
}
