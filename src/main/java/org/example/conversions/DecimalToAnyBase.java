package org.example.conversions;

import java.util.ArrayList;

public class DecimalToAnyBase {

    public static String convertToAnyBase(int inp, int base) {
        ArrayList<Character> charArr = new ArrayList<>();

        while (inp > 0) {
            charArr.add(reVal(inp % base));
            inp /= base;
        }

        StringBuilder str = new StringBuilder(charArr.size());

        for (Character ch : charArr) {
            str.append(ch);
        }

        return str.reverse().toString();
    }

    public static char reVal(int num) {
        if (num >= 0 && num <= 9) {
            return (char) (num + '0');
        } else {
            return (char) (num - 10 + 'A');
        }
    }
}
