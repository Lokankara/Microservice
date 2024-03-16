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

}
