package org.example.divideandconquer;

public class BinaryExponentiation {

    public static long calculatePower(long x, long y) {
        if (y == 0) {
            return 1;
        }
        if (y % 2 == 1) {
            return x * calculatePower(x, y - 1);
        }
        return calculatePower(x * x, y / 2);
    }
    long power(long N, long M) {
        long power = N, sum = 1;
        while (M > 0) {
            if ((M & 1) == 1) {
                sum *= power;
            }
            power = power * power;
            M = M >> 1;
        }
        return sum;
    }
}
