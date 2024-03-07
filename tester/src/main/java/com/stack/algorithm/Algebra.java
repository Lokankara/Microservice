package com.stack.algorithm;

public class Algebra {

    public static boolean checkFermat(int a, int p) {
        return Math.pow(a, p) % p == a;
    }
}
