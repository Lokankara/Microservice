package com.stack.loop;

public class Multiply {

    public int[] multiByThree() {
        int[] multiples = new int[33];
        for (int i = 1, r; (r = i * 3) < 101; i++) {
            multiples[i - 1] = r;
        }
        return multiples;
    }

    public int[] multiByThreeWhile() {
        int[] multiples = new int[33];
        int i = 1;
        int r;
        while ((r = i * 3) < 101) {
            multiples[i-1] = r;
            i++;
        }
        return multiples;
    }

    public int[] multiBy(int start, int end, int step) {
        int mod = start + (step - start % step) % step;
        int iterations = (end - mod + step - 1) / step;
        int[] arr = new int[iterations];
        for (int i = 0; i < iterations; i++) {
            arr[i] = mod + i * step;
        }
        return arr;
    }
}
