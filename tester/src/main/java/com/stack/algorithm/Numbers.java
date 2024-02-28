package com.stack.algorithm;

public class Numbers {

    private Numbers(){

    }

    static String isEven(String number) {
        try {
            return Integer.parseInt(number) % 2 == 0
                   ? "Even"
                   : "Odd";
        } catch (NumberFormatException e) {
            return "Invalid Data";
        }
    }
}
