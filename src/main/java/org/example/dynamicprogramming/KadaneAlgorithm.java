package org.example.dynamicprogramming;

public class KadaneAlgorithm {

    public static boolean max_Sum(int[] a, int predicted_answer) {
        int sum = a[0], running_sum = 0;
        for (int k : a) {
            running_sum = running_sum + k;
            sum = Math.max(sum, running_sum);
            if (running_sum < 0) running_sum = 0;
        }
        return sum == predicted_answer;
    }
}
