package org.example.dynamicprogramming;

public class LongestPalindromicSubstring {

    private static String LPS(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        boolean[][] arr = new boolean[input.length()][input.length()];
        int start = 0, end = 0;
        for (int g = 0; g < input.length(); g++) {
            for (int i = 0, j = g; j < input.length(); i++, j++) {
                if (g == 0) {
                    arr[i][j] = true;
                } else if (g == 1) {
                    arr[i][j] = input.charAt(i) == input.charAt(j);
                } else {
                    arr[i][j] = input.charAt(i) == input.charAt(j) && arr[i + 1][j - 1];
                }

                if (arr[i][j]) {
                    start = i;
                    end = j;
                }
            }
        }
        return input.substring(start, end + 1);
    }
}
