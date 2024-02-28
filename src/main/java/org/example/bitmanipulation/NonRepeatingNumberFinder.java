package org.example.bitmanipulation;

public class NonRepeatingNumberFinder {

    public static int findNonRepeatingNumber(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }
}
