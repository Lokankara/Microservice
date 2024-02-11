package com.stack.kata;

public class JomoPipi {
    public static String stringFunc(String s, long x) {
        if (x == 0) return s;
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            int j = i, k = chars.length - 1;
            while (j < k) {
                char temp = chars[j];
                chars[j] = chars[k];
                chars[k] = temp;
                j++;
                k--;
            }
            i++;
        }
        return stringFunc(String.valueOf(chars), x - 1);
    }
}
