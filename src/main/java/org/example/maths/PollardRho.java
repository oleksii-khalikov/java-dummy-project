package org.example.maths;

public class PollardRho {

    static int g(int base, int modulus) {
        return ((base * base) - 1) % modulus;
    }

    static int pollardRho(int number) {
        int x = 2, y = 2, d = 1;
        while (d == 1) {
            x = g(x, number);
            y = g(g(y, number), number);
            d = GCD.gcd(Math.abs(x - y), number);
        }
        if (d == number) {
            throw new RuntimeException("GCD cannot be found.");
        }
        return d;
    }
}
