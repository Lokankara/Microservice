package com.stack.structure.array;

public class MatrixSum {

    int[][] sum(int n, int m, String lines) {
        int[][] matrix = new int[n][m];
        int[][] sums = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = lines.split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0) {
                    sums[i][j] += sums[i - 1][j];
                }
                if (j > 0) {
                    sums[i][j] += sums[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    sums[i][j] -= sums[i - 1][j - 1];
                }
                sums[i][j] += matrix[i][j];
            }
        }
        return sums;
    }
}
