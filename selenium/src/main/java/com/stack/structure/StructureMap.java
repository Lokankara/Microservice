package com.stack.structure;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class StructureMap {

    public static Map<Character, String> getLongestWordsByLetters(List<String> words) {
        Map<Character, String> longestWords = new HashMap<>();
        for (String word : words) {
            char firstLetter = word.charAt(0);
            if (word.length() > longestWords.getOrDefault(firstLetter, "").length()) {
                longestWords.put(firstLetter, word);
            }
        }
        return longestWords;
    }

    public static void printMap(Map<Character, String> longestWords) {
        for (Map.Entry<Character, String> entry : longestWords.entrySet()) {
            log.info("The longest word '" + entry.getKey() + "': " + entry.getValue());
        }
    }
}
