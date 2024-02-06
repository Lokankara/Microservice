package com.stack.loop;

import java.util.Random;

public class MoveZeros {
    private final Random random = new Random();

    public int[] moveZeros(int[] arr) {
        int[] result = new int[arr.length];
        System.arraycopy(arr, 0, result, 0, arr.length);

        int l = 0;
        int r = 0;

        while (r < result.length && result[r] != 0) {
            r++;
        }

        while (l < result.length && r < result.length) {
            while (l < result.length && result[l] != 0) {
                l++;
            }
            while (r < result.length && result[r] == 0) {
                r++;
            }
            if (r < result.length && l < result.length) {
                int t = result[l];
                result[l] = result[r];
                result[r] = t;
            } else {
                return result;
            }
            r++;
            l++;
        }
        return result;
    }

    public int[] fillArray(int size) {
        int[] arr = new int[size];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = random.nextInt(1000);
        }

        for (int j = 0; j < random.nextInt(50); j++) {
            arr[j] = 0;
        }
        return arr;
    }
}
