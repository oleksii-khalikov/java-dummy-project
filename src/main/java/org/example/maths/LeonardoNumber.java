package org.example.maths;

public class LeonardoNumber {

    public static int leonardoNumber(int n) {
        if (n < 0) {
            throw new ArithmeticException();
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return (leonardoNumber(n - 1) + leonardoNumber(n - 2) + 1);
    }
}
