package org.example.maths;

import java.util.ArrayList;
import java.util.Collections;

public class VampireNumber {


    static boolean isVampireNumber(int a, int b, boolean noPseudoVamireNumbers) {
        if (noPseudoVamireNumbers) {
            if (a * 10 <= b || b * 10 <= a) {
                return false;
            }
        }

        String mulDigits = splitIntoDigits(a * b, 0);
        String faktorDigits = splitIntoDigits(a, b);

        return mulDigits.equals(faktorDigits);
    }

    static String splitIntoDigits(int num, int num2) {
        StringBuilder res = new StringBuilder();

        ArrayList<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        while (num2 > 0) {
            digits.add(num2 % 10);
            num2 /= 10;
        }
        Collections.sort(digits);
        for (int i : digits) {
            res.append(i);
        }

        return res.toString();
    }
}
