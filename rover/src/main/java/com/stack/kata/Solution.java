package com.stack.kata;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] arr = new boolean[m + 1][n + 1];

        arr[0][0] = true;
        IntStream.rangeClosed(1, n)
                .filter(j1 -> p.charAt(j1 - 1) == '*')
                .forEach(j1 -> arr[0][j1] = arr[0][j1 - 2]);

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (sc == pc || pc == '.') {
                    arr[i][j] = arr[i - 1][j - 1];
                } else if (pc == '*' && (j >= 2)) {
                        char prev = p.charAt(j - 2);
                    arr[i][j] = prev == sc || prev == '.'
                               ? arr[i][j - 2] || arr[i - 1][j]
                               : arr[i][j - 2];

                }
            }
        }
        return arr[m][n];
    }

    public long[] productArray(int[] numbers) {
        long amount = Arrays
                .stream(numbers)
                .asLongStream()
                .reduce(1, (a, b) -> a * b);

        return Arrays
                .stream(numbers)
                .mapToLong(number -> amount / number)
                .toArray();
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()
                        || strs[j].charAt(i)
                        != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
