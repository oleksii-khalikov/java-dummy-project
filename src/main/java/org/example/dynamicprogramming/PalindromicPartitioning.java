package org.example.dynamicprogramming;

import java.util.Scanner;

public class PalindromicPartitioning {

    public static int minimalpartitions(String word) {
        int len = word.length();
        int[] minCuts = new int[len];
        boolean[][] isPalindrome = new boolean[len][len];
        int i, j, L;
        for (i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
        }

        for (L = 2; L <= len; L++) {
            for (i = 0; i < len - L + 1; i++) {
                j = i + L - 1;
                if (L == 2) {
                    isPalindrome[i][j] = (word.charAt(i) == word.charAt(j));
                } else {
                    isPalindrome[i][j] = (word.charAt(i) == word.charAt(j)) && isPalindrome[i + 1][j - 1];
                }
            }
        }
        for (i = 0; i < len; i++) {
            if (isPalindrome[0][i]) {
                minCuts[i] = 0;
            } else {
                minCuts[i] = Integer.MAX_VALUE;
                for (j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i] && 1 + minCuts[j] < minCuts[i]) {
                        minCuts[i] = 1 + minCuts[j];
                    }
                }
            }
        }

        return minCuts[len - 1];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word;
        System.out.println("Enter the First String");
        word = input.nextLine();
        int ans = minimalpartitions(word);
        System.out.println("The minimum cuts needed to partition \"" + word + "\" into palindromes is " + ans);
        input.close();
    }
}
