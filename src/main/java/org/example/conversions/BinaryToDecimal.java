package org.example.conversions;

class BinaryToDecimal {

    public static long binaryToDecimal(long binNum) {
        long binCopy, d, s = 0, power = 0;
        binCopy = binNum;
        while (binCopy != 0) {
            d = binCopy % 10;
            s += d * (long) Math.pow(2, power++);
            binCopy /= 10;
        }
        return s;
    }
}

