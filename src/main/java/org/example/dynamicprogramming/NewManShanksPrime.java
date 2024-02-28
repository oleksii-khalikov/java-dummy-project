/**
 * Author : Siddhant Swarup Mallick
 * Github : https://github.com/siddhant2002
 */

/** Program description - To find the New Man Shanks Prime. */
/** Wikipedia Link - https://en.wikipedia.org/wiki/Newman%E2%80%93Shanks%E2%80%93Williams_prime */

package org.example.dynamicprogramming;

public class NewManShanksPrime {

    public static boolean nthManShanksPrime(int n, int expected_answer) {
        int[] a = new int[n + 1];
        a[0] = a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = 2 * a[i - 1] + a[i - 2];
        }
        return a[n] == expected_answer;
    }
}
