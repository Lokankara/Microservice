package com.stack.structure.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayAssignment {

    public int sumArrayTraverse(int[] array) {
        int size = array.length;
        int sum = size % 2 == 1
                  ? array[size / 2]
                  : 0;
        for (int i = 0; i < size / 2; i++) {
            sum += array[size - 1 - i] + array[i];
        }
        return sum;
    }

    public static double sum(double[] arr) {
        int len = arr.length;
        return IntStream.range(0, len / 2)
                        .mapToDouble(i -> arr[i] + arr[len - 1 - i])
                        .sum() + (len % 2 == 1
                                  ? arr[len / 2]
                                  : 0);
    }

    public int maxArray(int[] array) {
        int size = array.length;
        if (size == 0) {
            return Integer.MAX_VALUE;
        }
        for (int index = size / 2 - 1; index >= 0; index--) {
            heapify(array, size, index);
        }
        return array[0];
    }

    private void heapify(
            int[] array,
            int size,
            int root) {
        int max = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }

        if (max != root) {
            int temp = array[root];
            array[root] = array[max];
            array[max] = temp;
            heapify(array, size, max);
        }
    }

    public int minArray(int[] array) {
        if (array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int buffer = 3;
        int blocks = (int) Math.ceil((double) array.length / buffer);
        int[] arr = new int[blocks];
        for (int i = 0; i < blocks; i++) {
            int start = i * buffer;
            int end = Math.min((i + 1) * buffer, array.length);
            int[] block = Arrays.copyOfRange(array, start, end);
            Arrays.sort(block);
            arr[i] = block[0];
        }
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public double meanArray(int[] array) {
        return sumArrayTraverse(array) / (array.length * 1.0);
    }

    public int sum2DArray(int[][] array) {
        return Arrays.stream(array)
                     .mapToInt(this::sumArrayTraverse)
                     .sum();
    }

    public int max2DArray(int[][] array) {
        if (array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = maxArray(array[i]);
        }
        return maxArray(arr);
    }

    public int countElements(int[][] array) {
        int count = 0;
        for (int[] row : array) {
            count += row.length;
        }
        return count;
    }

    public int countBy2(
            String[][] array,
            char letter) {
        int count = 0;
        for (String[] row : array) {
            for (String words : row) {
                for (char c : words.toLowerCase()
                                   .toCharArray()) {
                    if (c == letter) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int countBy(
            String[][] array,
            char letter) {
        int width = array[0].length;
        int count = 0;
        int row;
        int col;
        for (int i = 0; i < array.length * width; i++) {
            row = i / width;
            col = i % width;
            if (col < array[row].length) {
                for (char c : array[row][col].toLowerCase()
                                             .toCharArray()) {
                    if (c == letter) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int findIndexOfUnique(int[] arr) {
        int reduce = Arrays.stream(arr).reduce(0, (a, b) -> a ^ b);
        return IntStream.range(0, arr.length)
                        .filter(i -> arr[i] == reduce)
                        .findFirst()
                        .orElse(0);
    }
}
