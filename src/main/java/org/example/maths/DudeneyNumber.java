package org.example.maths;

public class DudeneyNumber {

    public static boolean isDudeney(int n) {
        int cube_root = (int) (Math.round((Math.pow(n, 1.0 / 3.0))));
        if (cube_root * cube_root * cube_root != n) {
            return false;
        }
        int sum_of_digits = 0;
        int temp = n;
        while (temp > 0) {
            int rem = temp % 10;
            sum_of_digits += rem;
            temp /= 10;
        }


        return cube_root == sum_of_digits;
    }
}
