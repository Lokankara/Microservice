package com.stack.kata;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kata {

    public static void main(String[] args) {
        String reversed = reverseString("reverseString");
        String incrementString = incrementString("incrementString");
        System.out.printf("%s", reversed);
        System.out.printf("%s", incrementString);
    }

    public static String incrementString(String str) {

        Matcher matcher = Pattern.compile("(.*?)(\\d*)$").matcher(str);
        return matcher.find()
               ? matcher.group(2).isEmpty()
                 ? matcher.group(1) + "1"
                 : "%s%s".formatted(matcher.group(1),
                                    String.format("%0" + matcher
                                                          .group(2)
                                                          .length() + "d",
                                                  new BigInteger(matcher.group(2)).add(
                                                          BigInteger.ONE)))
               : "1";
    }

    public static String reverseString(String str) {
        return java.util.stream.IntStream
                .iterate(str.length() - 1, i -> i >= 0, i -> i - 1)
                .mapToObj(i -> String.valueOf(str.charAt(i)))
                .collect(java.util.stream.Collectors.joining());
    }

    public static long[] powersOfTwo(int n) {
        long[] result = new long[n + 1];
        java.util.stream.IntStream.rangeClosed(0, n)
                                  .forEach(i -> result[i] = (long) Math.pow(2, i));
        return result;
    }

}
