package org.example.maths;

public class PiNilakantha {
    public static double calculatePi(int iterations) {
        if (iterations < 0 || iterations > 500) {
            throw new IllegalArgumentException("Please input Integer Number between 0 and 500");
        }

        double pi = 3;
        int divCounter = 2;

        for (int i = 0; i < iterations; i++) {
            if (i % 2 == 0) {
                pi = pi + 4.0 / (divCounter * (divCounter + 1) * (divCounter + 2));
            } else {
                pi = pi - 4.0 / (divCounter * (divCounter + 1) * (divCounter + 2));
            }

            divCounter += 2;
        }
        return pi;
    }
}
