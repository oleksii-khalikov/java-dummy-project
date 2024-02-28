package org.example.maths;

import java.util.Arrays;

public class Median {

    public static double median(int[] values) {
        Arrays.sort(values);
        int length = values.length;
        return length % 2 == 0 ? (values[length / 2] + values[length / 2 - 1]) / 2.0 : values[length / 2];
    }
}
