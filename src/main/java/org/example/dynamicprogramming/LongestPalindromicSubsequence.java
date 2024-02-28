package org.example.dynamicprogramming;

public class LongestPalindromicSubsequence {

    public static String LPS(String original) throws IllegalArgumentException {
        StringBuilder reverse = new StringBuilder(original);
        reverse = reverse.reverse();
        return recursiveLPS(original, reverse.toString());
    }

    private static String recursiveLPS(String original, String reverse) {
        String bestResult = "";

        if (original.length() == 0 || reverse.length() == 0) {
            bestResult = "";
        } else {
            if (original.charAt(original.length() - 1) == reverse.charAt(reverse.length() - 1)) {
                String bestSubResult = recursiveLPS(original.substring(0, original.length() - 1), reverse.substring(0, reverse.length() - 1));

                bestResult = reverse.charAt(reverse.length() - 1) + bestSubResult;
            } else {

                String bestSubResult1 = recursiveLPS(original, reverse.substring(0, reverse.length() - 1));
                String bestSubResult2 = recursiveLPS(original.substring(0, original.length() - 1), reverse);
                if (bestSubResult1.length() > bestSubResult2.length()) {
                    bestResult = bestSubResult1;
                } else {
                    bestResult = bestSubResult2;
                }
            }
        }

        return bestResult;
    }
}
