package com.stack.algorithm;

import java.util.HashSet;
import java.util.Set;

public class UniqueCount {

    private UniqueCount(){
    }

    public static int countUniqueLetters(String word) {
        if (word == null){
            return -1;
        }
        Set<Character> uniqueLetters = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            uniqueLetters.add(word.charAt(i));
        }
        return uniqueLetters.size();
    }

    public static int countCyrillicCharacters(String text) {
        if (text == null){
            return -1;
        }
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 1040 && ch <= 1103) {
                count++;
            }
        }
        return count;
    }

}
