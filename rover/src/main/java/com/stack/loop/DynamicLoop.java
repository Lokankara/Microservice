package com.stack.loop;

import java.util.Arrays;

public class DynamicLoop {

    public String[] multiplicityTask(int start, int end, int step) {
        int size = (int) Math.ceil((end - start) / (step * 1.0));
        String[] result = new String[size];
        result[0] = "None";
        double iterations = (end - start) / (step * 1.0);
        for (int i = 0; i < iterations && iterations >= 1; i++) {
            result[i] = String.valueOf(((start / step + i) * step));
        }
        return result;
    }

    public String[] multiplicity(int start, int end, int step) {
        int size = (int) Math.ceil((end - start) / (step * 1.0));
        String[] result = new String[size];

        int j = 0;
        for (int i = start; i < end; i++) {
            if (i % step == 0) {
                result[j++] = String.valueOf(i);
            }
        }
        return j == 0
               ? new String[]{"None"}
               : Arrays.copyOf(result, j);
    }
}
