package org.example.others;

public class RootPrecision {


    public static double squareRoot(int N, int P) {
        double rv;

        double root = Math.pow(N, 0.5);

        int precision = (int) Math.pow(10, P);
        root = root * precision;

        rv = (int) root;
        return rv / precision;
    }
}
