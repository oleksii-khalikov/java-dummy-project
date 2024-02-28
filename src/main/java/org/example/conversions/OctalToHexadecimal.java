package org.example.conversions;


public class OctalToHexadecimal {
    public static int octToDec(String s) {
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char num = s.charAt(j);
            num -= '0';
            i *= 8;
            i += num;
        }
        return i;
    }

    public static String decimalToHex(int d) {
        String digits = "0123456789ABCDEF";
        if (d <= 0) {
            return "0";
        }
        String hex = "";
        while (d > 0) {
            int digit = d % 16;
            hex = digits.charAt(digit) + hex;
            d = d / 16;
        }
        return hex;
    }
}

