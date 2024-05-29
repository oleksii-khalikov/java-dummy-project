package org.example.maths;

import java.util.TreeMap;

public class SimpsonIntegration {

    public double simpsonsMethod(int N, double h, double a) {
        TreeMap<Integer, Double> data = new TreeMap<>();
        double temp;
        double xi = a;
        for (int i = 0; i <= N; i++) {
            temp = f(xi);
            data.put(i, temp);
            xi += h;
        }

        double integralEvaluation = 0;
        for (int i = 0; i < data.size(); i++) {
            if (i == 0 || i == data.size() - 1) {
                integralEvaluation += data.get(i);
                System.out.println("Multiply f(x" + i + ") by 1");
            } else if (i % 2 == 1) {
                integralEvaluation += (double) 4 * data.get(i);
                System.out.println("Multiply f(x" + i + ") by 4");
            } else {
                integralEvaluation += (double) 2 * data.get(i);
                System.out.println("Multiply f(x" + i + ") by 2");
            }
        }

        integralEvaluation = h / 3 * integralEvaluation;

        return integralEvaluation;
    }

    public double f(double x) {
        return Math.exp(-x) * (4 - Math.pow(x, 2));
    }
}
