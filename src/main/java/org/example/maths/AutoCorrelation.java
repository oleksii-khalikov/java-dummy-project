package org.example.maths;


public class AutoCorrelation {

    public static double[] autoCorrelation(double[] x) {


        return CrossCorrelation.crossCorrelation(x, x);
    }
}
