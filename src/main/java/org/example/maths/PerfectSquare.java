package org.example.maths;

public final class PerfectSquare {
    private PerfectSquare() {
    }

    public static boolean isPerfectSquare(final int number) {
        final int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }
}
