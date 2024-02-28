package org.example.dynamicprogramming;

import java.util.Scanner;

public class CatalanNumber {

    static long findNthCatalan(int n) {
        long[] catalanArray = new long[n + 1];

        catalanArray[0] = 1;
        catalanArray[1] = 1;

        for (int i = 2; i <= n; i++) {
            catalanArray[i] = 0;
            for (int j = 0; j < i; j++) {
                catalanArray[i] += catalanArray[j] * catalanArray[i - j - 1];
            }
        }

        return catalanArray[n];
    }
}
