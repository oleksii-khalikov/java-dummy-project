/**
 * Author : Siddhant Swarup Mallick
 * Github : https://github.com/siddhant2002
 */
/**
 * In mathematics, the Golomb sequence is a non-decreasing integer sequence where n-th term is equal
 * to number of times n appears in the sequence.
 */

/**
 * Wikipedia Link - https://en.wikipedia.org/wiki/Golomb_sequence
 */

/** Program description - To find the Golomb sequence upto n */

package org.example.dynamicprogramming;

public class CountFriendsPairing {

    public static boolean countFriendsPairing(int n, int[] a) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1 + dp[i - dp[dp[i - 1]]];
        }
        for (int i = 1; i < n; i++) {
            if (a[i - 1] != dp[i]) {
                return false;
            }
        }
        return true;
    }
}
