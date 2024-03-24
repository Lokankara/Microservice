package com.stack.structure;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class StructureMap {

    private StructureMap(){}

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

    public static int countUniqueLetters(String word) {
        if (word == null){
            return -1;
        }
        Set<Character> uniqueLetters = new HashSet<>();
        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                uniqueLetters.add(ch);
            }
        }
        return uniqueLetters.size();
    }

    public static int countCyrillicCharacters(String text) {
        if(text == null) return -1;

        Matcher matcher = Pattern.compile("[а-яА-Я]").matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
