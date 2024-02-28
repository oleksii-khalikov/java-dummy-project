package org.example.others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HappyNumbersSeq {

    private static final Set<Integer> CYCLE_NUMS = new HashSet<>(Arrays.asList(4, 16, 20, 37, 58, 145));


    private static int sumSquares(int n) {
        int s = 0;
        for (; n > 0; n /= 10) {
            int r = n % 10;
            s += r * r;
        }
        return s;
    }

    private static boolean isSad(int n) {
        return CYCLE_NUMS.contains(n);
    }
}
