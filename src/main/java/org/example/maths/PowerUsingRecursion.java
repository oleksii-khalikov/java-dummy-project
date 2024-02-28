package org.example.maths;

public class PowerUsingRecursion {

    public static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }
}
