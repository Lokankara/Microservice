package com.stack.structure.string;

import java.util.Arrays;

public class TransformString {

    public String permutation(
            String input,
            char letter) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toLowerCase().toCharArray()) {
            if (c == letter) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public int countLetters(
            String input,
            char letter) {
        int counter = 0;
        for (char c : input.toLowerCase().toCharArray()) {
            if (c == letter) {
                counter++;
            }
        }
        return counter;
    }

    public int[] findIndexes(String input, String letters) {
        int[] temp = new int[input.length()];
        int count = 0;
        int current = 0;
        while (current != -1) {
            current = input.toLowerCase().indexOf(letters.toLowerCase(), current);
            if (current != -1) {
                temp[count] = current;
                count++;
                current++;
            }
        }
        int[] result = new int[count];
        System.arraycopy(temp, 0, result, 0, count);
        return result;
    }
}
