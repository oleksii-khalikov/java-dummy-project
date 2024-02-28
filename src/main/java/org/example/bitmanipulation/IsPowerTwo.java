package org.example.bitmanipulation;

public class IsPowerTwo {
    public static boolean isPowerTwo(int number) {
        if (number <= 0) {
            return false;
        }
        int ans = number & (number - 1);
        return ans == 0;
    }
}
