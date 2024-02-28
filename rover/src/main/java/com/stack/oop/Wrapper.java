package com.stack.oop;

public class Wrapper {

    public String getPrice(String coin) {
        int parsed = parseTo(coin);
        return parsed > 0 && parsed < 101
               ? "The cost of the goods is %s.00 coins".formatted(coin)
               : "Invalid data";
    }

    private int parseTo(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new NumberParseException(e.getMessage());
        }
    }

    public String getArrayInfo(String[] array) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String string : array) {
            int number = parseTo(string);
            sum += number;
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        return String.format(
                "Min: %d, max: %d, amount: %s",
                min, max, sum);
    }

    public <T extends Comparable<T>> int compare(T a, T b) {
        return a.compareTo(b);
    }
}
