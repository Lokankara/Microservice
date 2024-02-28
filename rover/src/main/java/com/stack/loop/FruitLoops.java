package com.stack.loop;

public class FruitLoops {
    private static final String[] COLORS = {"purple", "yellow", "red", "orange", "blue", "green"};
    private static final double ERROR_MARGIN = 0.05;
    private static final int EXPECTED_TOTAL = 1500;

    public boolean checkFruit(int[] box) {

        int totalRings = 0;
        int expectedPerColor = EXPECTED_TOTAL / COLORS.length;
        int lowerBound = (int) Math.round(expectedPerColor * (1 - ERROR_MARGIN));
        int upperBound = (int) Math.round(expectedPerColor * (1 + ERROR_MARGIN));

        for (int anInt : box) {
            totalRings += anInt;
            if (anInt < lowerBound || anInt > upperBound) {
                return false;
            }
        }

        return totalRings == EXPECTED_TOTAL;
    }


    public boolean checkBox(int[] box) {
        int totalRings = 0;
        int perColor = EXPECTED_TOTAL / COLORS.length;

        for (int anInt : box) {
            totalRings += anInt;
            if (Math.abs(anInt - perColor) > perColor * ERROR_MARGIN) {
                return false;
            }
        }

        return totalRings >= EXPECTED_TOTAL;
    }
}
