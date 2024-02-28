package org.example.maths;

import java.util.*;

public class LeastCommonMultiple {
    public static int lcm(int num1, int num2) {
        int high, num3;
        int cmv = 0;
        if (num1 > num2) {
            high = num3 = num1;
        } else {
            high = num3 = num2;
        }

        while (num1 != 0) {
            if (high % num1 == 0 && high % num2 == 0) {
                cmv = high;
                break;
            }
            high += num3;
        }
        return cmv;
    }
}
