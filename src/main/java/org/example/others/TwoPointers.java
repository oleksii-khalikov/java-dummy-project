package org.example.others;

import java.util.Arrays;

class TwoPointers {

    public static boolean isPairedSum(int[] arr, int key) {
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[i] + arr[j] == key) {
                return true;
            } else if (arr[i] + arr[j] < key) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
