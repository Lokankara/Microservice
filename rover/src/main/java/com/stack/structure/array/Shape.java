package com.stack.structure.array;

public class Shape {

    public int[][] leftDownQuadrant(int size) {
        int[][] triangle = new int[size][];
        for (int i = 0; i < size; i++) {
            triangle[i] = new int[size - i];
            for (int j = 0; j < size - i; j++) {
                triangle[i][j] = j;
            }
        }
        return triangle;
    }

    public String[][] offsetTriangle(int size) {
        String[][] triangle = new String[size][size];
        for (int i = 0; i < size * size; i++) {
            int row = i / size;
            int col = i % size;
            triangle[row][col] = (col < row) ? " " : String.valueOf(col - row);
        }
        return triangle;
    }

    public String[][] offsetPyramidUp(int size) {
        String[][] pyramid = new String[size][2 * size - 1];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < 2 * size - 1; col++) {
                pyramid[row][col] = col < size - row - 1 || col > size + row - 1
                                ? " " : String.valueOf(Math.abs(size - col - 1));
            }
        }
        return pyramid;
    }

    public String[][] offsetPyramid(int size) {
        String[] array = new String[size * (2 * size - 1)];
        String[][] pyramid = new String[size][2 * size - 1];
        for (int i = 0; i < array.length; i++) {
            int row = i / (2 * size - 1);
            int col = i % (2 * size - 1);
            array[i] = col < row || col >= 2 * size - row - 1
                           ? " " : String.valueOf(Math.abs(size - col - 1));
        }
        for (int i = 0; i < array.length; i++) {
            pyramid[i / (2 * size - 1)][i % (2 * size - 1)] = array[i];
        }
        return pyramid;
    }
}
