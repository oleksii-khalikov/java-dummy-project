package org.example.sorts;

import java.util.Random;

public class SortUtilsRandomGenerator {

    private static final Random random;
    private static final long seed;

    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    public static Double[] generateArray(int size) {
        Double[] arr = new Double[size];
        for (int i = 0; i < size; i++) arr[i] = generateDouble();
        return arr;
    }

    public static Double generateDouble() {
        return random.nextDouble();
    }

    public static int generateInt(int n) {
        return random.nextInt(n);
    }
}
