package org.example.dynamicprogramming;

public class Tribonacci {

    public static int compute(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int first = 0, second = 1, third = 1;

        for (int i = 3; i <= n; i++) {
            int next = first + second + third;
            first = second;
            second = third;
            third = next;
        }

        return third;
    }
}