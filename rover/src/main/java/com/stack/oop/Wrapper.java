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

    public int compareBy(Number a, Number b){

        if(a instanceof Integer){
            return Integer.compare(a.intValue(), b.intValue());
        }
        if(a instanceof Double){
            return Double.compare(a.doubleValue(), b.doubleValue());
        }
        if(a instanceof Short){
            return Short.compare(a.shortValue(), b.shortValue());
        }
        if(a instanceof Byte){
            return Byte.compare(a.byteValue(), b.byteValue());
        }
        if(a instanceof Long){
            return Long.compare(a.longValue(), b.longValue());
        }
        if(a instanceof Float){
            return Float.compare(a.floatValue(), b.floatValue());
        }
        return Integer.MIN_VALUE;
    }
}
