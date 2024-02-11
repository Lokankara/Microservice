package com.stack.combinatoric;

import java.util.stream.IntStream;

public class Mouse {
    public String count(String lines) {
        String[] dimensions = lines.split(" ");

        int m = Integer.parseInt(dimensions[0]);
        int n = Integer.parseInt(dimensions[1]);

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(dimensions[j]);
            }
        }

        swap(m, arr);

        IntStream.range(1, m).forEach(l -> arr[l][0] += arr[l - 1][0]);
        IntStream.range(1, n).forEach(k -> arr[0][k] += arr[0][k - 1]);
        IntStream.range(1, m).forEach(
                o -> IntStream.range(1, n).forEach(
                        j -> arr[o][j] += Math.max(
                                arr[o - 1][j], arr[o][j - 1])));

        return getResult(m, n, arr);
    }

    private void swap(int m, int[][] arr) {
        for (int i = 0; i < m / 2; i++) {
            int[] temp = arr[i];
            arr[i] = arr[m - i - 1];
            arr[m - i - 1] = temp;
        }
    }

    private String getResult(
            int m,
            int n,
            int[][] arr) {
        StringBuilder path = new StringBuilder();

        int i = m - 1;
        int j = n - 1;

        while (i > 0 || j > 0) {
            if (i == 0 || (j > 0 && arr[i - 1][j] < arr[i][j - 1])) {
                path.append("R");
                j--;
            } else {
                path.append("F");
                i--;
            }
        }
        return path.reverse().toString();
    }
}
