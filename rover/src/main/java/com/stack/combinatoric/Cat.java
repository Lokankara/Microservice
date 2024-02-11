package com.stack.combinatoric;

import java.util.Arrays;

public class Cat {
    String[] catsNames = {"Grey", "Black", "Tom", "Lucky", "Jerry", "SnowBall", "Puss", "Tabby"};

    public String[] findBy(
            String[] cats,
            char[] letters) {
        int count = 0;
        String[] result = new String[cats.length - 1];
        for (int i = 0; i < cats.length; i++) {
            for (char letter : letters) {
                if (cats[i].startsWith(String.valueOf(letter))) {
                    result[i] = cats[i];
                    count++;
                    break;
                }
            }
        }
        return Arrays.copyOf(result, count);
    }
}
