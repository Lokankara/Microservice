package com.stack.structure.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
        double sum = 0.0;
        int bound = len / 2;
        for (int i = 0; i < bound; i++) {
            sum += arr[i] + arr[len - 1 - i];
        }
        return sum + (len % 2 == 1 ? arr[len / 2] : 0);
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

    public int countElements(
            int[][] array) {
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
                for (char c : words.toLowerCase().toCharArray()) {
                    if (c == letter) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int countLetter(String[][] array, char letter) {
        int count = 0;
        for (String[] row : array) {
            for (String str : row) {
                count += countLetterInString(str, letter);
            }
        }
        return count;
    }

    private int countLetterInString(String str, char letter) {
        int count = 0;
        for (char c : str.toLowerCase().toCharArray()) {
            count += (c ^ letter) == 0 ? 1 : 0;
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
                for (char c : array[row][col].toLowerCase().toCharArray()) {
                    if (c == letter) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int findIndexOfUnique(int[] arr) {
        int uniqueChar = 0;
        for (int c : arr) {
            uniqueChar ^= c;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == uniqueChar) {
                return i;
            }
        }
        return 0;
    }

    public int findIndexOfSingleNumberList(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                return i;
            }
        }
        return 0;
    }

    public int findIndexOfSingleNumberLists(int[] arr) {
        List<Integer> list = Arrays.stream(arr)
                                   .boxed()
                                   .toList();
        return IntStream.range(0, list.size())
                        .filter(i -> Collections.frequency(list, list.get(i)) == 1)
                        .findFirst()
                        .orElse(0);
    }


    public int findIndexOfSingleNumber(int[] arr) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        Arrays.stream(arr).forEach(
                number -> countMap.put(
                        number, countMap.getOrDefault(
                                number, 0) + 1));
        return IntStream.range(0, arr.length)
                        .filter(i -> countMap.get(arr[i]) == 1)
                        .findFirst()
                        .orElse(0);
    }

    public int findIndexOfSingleChar(char[] arr) {
        char uniqueChar = 0;
        for (char c : arr) {
            uniqueChar ^= c;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == uniqueChar) {
                return i;
            }
        }
        return 0;
    }
}
