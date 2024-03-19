package com.stack.structure.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Structure {

    List<String> mutable = new ArrayList<>();
    List<String> unmodifiable = List.of();

    public static void main(String[] args) {
        List<Integer> myInt = Arrays.asList(new Integer[100]);
        Collections.fill(myInt, -100);
    }

    public List<String> removeColorsWithLetter(char letter, List<String> colors) {
        List<String> result = new ArrayList<>();
        for (String color : colors) {
            if (!color.contains(String.valueOf(letter))) {
                result.add(color);
            }
        }
        return result;
    }

    public List<Integer> fillListFrom100To1000() {
        List<Integer> numbers = new ArrayList<>();
        int value = 100;
        while (value < 1001) {
            numbers.add(value++);
        }
        return numbers;
    }

    public List<Integer> removeEvenNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (int num : numbers) {
            if (num % 2 != 0) {
                result.add(num);
            }
        }
        return result;
    }
}
