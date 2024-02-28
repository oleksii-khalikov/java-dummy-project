/**
 * Author: Siddhant Swarup Mallick
 * Github: https://github.com/siddhant2002
 * <p>
 * Problem Description:
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * <p>
 * Program Description:
 * This program calculates the number of unique paths possible for a robot to reach the bottom-right corner
 * of an m x n grid using dynamic programming.
 */

package org.example.dynamicprogramming;

import java.util.Arrays;

public final class UniquePaths {

    private UniquePaths(){};

    public static int uniquePaths(final int m, final int n) {
        if (m > n) {
            return uniquePaths(n, m);
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = Math.addExact(dp[j], dp[j - 1]);
            }
        }
        return dp[n - 1];
    }

    public static int uniquePaths2(final int m, final int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.addExact(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
