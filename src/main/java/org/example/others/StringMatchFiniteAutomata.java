package org.example.others;

import java.util.Scanner;

public class StringMatchFiniteAutomata {

    public static final int CHARS = 256;
    public static int[][] FA;
    public static Scanner scanner = null;

    public static void searchPat(String text, String pat) {
        int m = pat.length();
        int n = text.length();

        FA = new int[m + 1][CHARS];

        computeFA(pat, m, FA);

        int state = 0;
        for (int i = 0; i < n; i++) {
            state = FA[state][text.charAt(i)];

            if (state == m) {
                System.out.println("Pattern found at index " + (i - m + 1));
            }
        }
    }

    public static void computeFA(String pat, int m, int[][] FA) {
        for (int state = 0; state <= m; ++state) {
            for (int x = 0; x < CHARS; ++x) {
                FA[state][x] = getNextState(pat, m, state, x);
            }
        }
    }

    public static int getNextState(String pat, int m, int state, int x) {
        if (state < m && x == pat.charAt(state)) {
            return state + 1;
        }

        for (int ns = state; ns > 0; ns--) {
            if (pat.charAt(ns - 1) == x) {
                for (int i = 0; i < ns - 1; i++) {
                    if (pat.charAt(i) != pat.charAt(state - ns + i + 1)) {
                        break;
                    }

                    if (i == ns - 1) {
                        return ns;
                    }
                }
            }
        }

        return 0;
    }
}
