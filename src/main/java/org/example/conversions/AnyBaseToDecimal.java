package org.example.conversions;

public class AnyBaseToDecimal {


    public static int convertToDecimal(String s, int radix) {
        int num = 0;
        int pow = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = valOfChar(s.charAt(i));
            if (digit >= radix) {
                throw new NumberFormatException("For input string " + s);
            }
            num += valOfChar(s.charAt(i)) * pow;
            pow *= radix;
        }
        return num;
    }

    public static int valOfChar(char c) {
        if (!(Character.isUpperCase(c) || Character.isDigit(c))) {
            throw new NumberFormatException("invalid character :" + c);
        }
        return Character.isDigit(c) ? c - '0' : c - 'A' + 10;
    }
}
