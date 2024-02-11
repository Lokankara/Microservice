package com.stack.combinatoric;

public class Snake {
    public int[][] bypassMatrix(int n) {
        int[][] arr = new int[n][n];
        int row = 0;
        int col = 0;
        int number = 1;
        int direction = 1;

        while (number <= n * n) {
            arr[row][col] = number++;
            if (direction == 1) {
                if (col == n - 1 || arr[row][col + 1] != 0) {
                    direction = -1;
                    row++;
                } else {
                    col++;
                }
            } else {
                if (col == 0 || arr[row][col - 1] != 0) {
                    direction = 1;
                    row++;
                } else {
                    col--;
                }
            }
        }
        return arr;
    }
}
