package org.example.others;

public class ReturnSubsequence {
    private static String[] returnSubsequence(String givenString) {
        if (givenString.length() == 0) {
            String[] ans = new String[1];
            ans[0] = "";
            return ans;
        }
        String[] SmallAns = returnSubsequence(givenString.substring(1)); // recursive call to get subsequences of substring starting from index

        String[] ans = new String[2 * SmallAns.length];
        int i = 0;
        for (; i < SmallAns.length; i++) {
            ans[i] = SmallAns[i];
        }
        for (int k = 0; k < SmallAns.length; k++) {
            ans[k + SmallAns.length] = givenString.charAt(0) + SmallAns[k]; // Insert character at index=0 of the given
        }
        return ans;
    }
}
