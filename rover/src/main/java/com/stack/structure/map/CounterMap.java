package com.stack.structure.map;

import java.util.HashMap;
import java.util.Map;

public class CounterMap {

    private CounterMap(){

    }

    public static Map<Character, Integer> countLetters(String sentence){
        Map<Character, Integer> result = new HashMap<>();
        return sentence == null
               ? result
               : count(sentence, result);

    }

    private static Map<Character, Integer> count(
            String sentence,
            Map<Character, Integer> result) {
        for (char c : sentence.toLowerCase().toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;
    }
}
