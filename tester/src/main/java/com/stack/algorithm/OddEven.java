package com.stack.algorithm;
public class OddEven {
    public String oddEven(String number) {
        if (number == null) {
            return "We have problems on our side. Try again later...";
        } else if (number.isEmpty()) {
            return "Empty number. Please input valid number.";
        } else {
            try {
                return Integer.parseInt(number) % 2 == 0 ? "Even" : "Odd";
            } catch (NumberFormatException e) {
                return !isDigital(number)
                       ? "Non-numeric data. Please input valid number."
                       : "Out of range Data. Please input valid number.";
            }
        }
    }

    private boolean isDigital(String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
