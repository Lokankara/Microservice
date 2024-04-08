package com.stack.strings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegexMap {
    private static final char[] OPENING_BRACKETS = {'(', '[', '{'};
    private static final char[] CLOSING_BRACKETS = {')', ']', '}'};

    public boolean verifyBrackets(String text) {

        Deque<Character> stack = new ArrayDeque<>();

        int i = 0;
        while (i < text.length()) {
            char ch = text.charAt(i);
            if (ch == '\\' && i < text.length() - 1) {
                i++;
            } else {
                if (isOpenBracket(ch)) {
                    stack.push(ch);
                } else if (isCloseBracket(ch)) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (!bracketsMatch(stack.pop(), ch)) {
                        return false;
                    }
                }
            }
            i++;
        }
        return stack.isEmpty();
    }

    private boolean isOpenBracket(char ch) {
        for (char openBracket : OPENING_BRACKETS) {
            if (openBracket == ch) {
                return true;
            }
        }
        return false;
    }

    private boolean isCloseBracket(char ch) {
        for (char closeBracket : CLOSING_BRACKETS) {
            if (closeBracket == ch) {
                return true;
            }
        }
        return false;
    }

    private boolean bracketsMatch(char openBracket, char closeBracket) {
        for (int i = 0; i < OPENING_BRACKETS.length; i++) {
            if (OPENING_BRACKETS[i] == openBracket
                && CLOSING_BRACKETS[i] == closeBracket) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBrackets(String text) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (brackets.containsKey(ch) || brackets.containsValue(ch)) {
                if (i > 0 && text.charAt(i - 1) == '\\') {
                    continue;
                }
                if (brackets.containsValue(ch)) {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty() || !Objects.equals(brackets.get(ch), stack.pop())) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public String reformatLines(String text) {
        StringBuilder result = new StringBuilder();
        StringBuilder line = new StringBuilder();

        text = text.replaceAll("\\s+", " ");

        for (String word : text.split("\\s")) {
            if (line.length() + word.length() > 60) {
                result.append(line.toString().trim()).append("\n");
                line = new StringBuilder();
            }
            line.append(word).append(" ");
        }

        if (!line.isEmpty()) {
            result.append(line.toString().trim());
        }

        return result.toString();
    }
}
