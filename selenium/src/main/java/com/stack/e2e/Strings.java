package com.stack.e2e;

public class Strings {

    static String capitalizeSentence(String sentence) {
        return sentence.substring(0, 1).toUpperCase()
                + sentence.substring(1) ;
    }
}
