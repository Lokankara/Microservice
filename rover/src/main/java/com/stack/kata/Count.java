package com.stack.kata;

import java.math.BigDecimal;

public class Count {

    double getSumFromString(String a, String b){
        return BigDecimal.ZERO.add(getNumbers(a))
                              .add(getNumbers(b))
                              .doubleValue();
    }

    private BigDecimal getNumbers(String str) {
        BigDecimal sum = BigDecimal.ZERO;
        StringBuilder numStr = new StringBuilder();
        boolean negative = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch) || ch == '.') {
                numStr.append(ch);
            } else if (ch == '-') {
                negative = true;
            } else {
                if (!numStr.isEmpty()) {
                    sum = getBigDecimal(numStr, negative, sum);
                    numStr.setLength(0);
                }
            }
        }
        if (!numStr.isEmpty()) {
            sum = getBigDecimal(numStr, negative, sum);
        }
        return sum;
    }

    private BigDecimal getBigDecimal(
            StringBuilder numStr,
            boolean negative,
            BigDecimal sum) {
        BigDecimal num = new BigDecimal(numStr.toString());
        if (negative) {
            num = num.negate();
        }
        sum = sum.add(num);
        return sum;
    }
}
