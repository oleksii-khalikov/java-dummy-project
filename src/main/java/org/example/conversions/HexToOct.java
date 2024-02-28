package org.example.conversions;

public class HexToOct {
    public static int hex2decimal(String s) {
        String str = "0123456789ABCDEF";
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            int n = str.indexOf(a);
            val = 16 * val + n;
        }
        return val;
    }

    public static int decimal2octal(int q) {
        int now;
        int i = 1;
        int octnum = 0;
        while (q > 0) {
            now = q % 8;
            octnum = (now * (int) (Math.pow(10, i))) + octnum;
            q /= 8;
            i++;
        }
        octnum /= 10;
        return octnum;
    }
}
