package com.stack.condition;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FizzBuzzWoof {

    private static final String F = "Fizz ";
    private static final String B = "Buzz ";
    private static final String W = "Woof ";
    public static void main(String[] args) {
        log.info(bingo(0, 101, 1));
        log.info(bingo(-1, 102, 2));
        log.info(fizzBuzz(-2, 108, 2));
        log.info(fizzBuzz(0, 100, 1));
    }

    public String fizzBuzzWoof(int start, int end, int step) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i += step) {
            StringBuilder temp = getBuilder(i);
            if (temp.isEmpty()) {
                result.append(i).append(", ");
            } else {
                result.append(temp.toString().trim()).append(" (").append(i).append("), ");
            }
        }
        return result.substring(0, result.length() - 2);
    }

    private StringBuilder getBuilder(int i) {
        int x = count(i, 3);
        int y = count(i, 5);
        int z = count(i, 7);

        boolean three = i % 3 == 0;
        boolean five = i % 5 == 0;
        boolean seven = i % 7 == 0;

        StringBuilder temp = new StringBuilder();

        if (three || x > 0) {
            temp.append(F.repeat(x + (three ? 1 : 0)));
        }
        if (five || y > 0) {
            temp.append(B.repeat(y + (five ? 1 : 0)));
        }
        if (seven || z > 0) {
            temp.append(W.repeat(z + (seven ? 1 : 0)));
        }
        return temp;
    }

    private int count(int num, int word) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == word) {
                count++;
            }
            num /= 10;
        }
        return count;
    }

    static String fizzBuzz(
            int start,
            int end,
            int step) {
        StringBuilder result = new StringBuilder();

        for (int number = start; number < end; number += step) {
            boolean fifth = number % 5 == 0;
            boolean third = number % 3 == 0;

            if (fifth && third) {
                result.append("Fizz Buzz, ");
            } else if (fifth) {
                result.append("Buzz, ");
            } else if (third) {
                result.append("Fizz, ");
            } else {
                result.append(number).append(", ");
            }
        }

        if (!result.isEmpty()) {
            result.setLength(result.length() - 2);
        }

        return result.toString();
    }

    private static String bingo(int start, int end, int step) {
        StringBuilder message = new StringBuilder();
        for (int number = start; number < end; number += step) {
            boolean fifth = number % 5 == 0;
            boolean third = number % 3 == 0;
            boolean seventh = number % 7 == 0;
            if (0 < number && number < 106) {
                if (fifth && third || third && seventh || fifth && seventh) {
                    message.append("Bingo ");
                } else if (seventh) {
                    message.append("* ");
                } else if (fifth) {
                    message.append("! ");
                } else if (third) {
                    message.append("? ");
                } else {
                    message.append(number).append(" ");
                }
            }
            message.append("Out of scope ");
        }
        return String.join(", ", message);
    }
}
