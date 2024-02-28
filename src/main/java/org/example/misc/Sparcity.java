package org.example.misc;

class Sparcity {

    static double sparcity(double[][] mat) {
        int zero = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    zero++;
                }
            }
        }
        return ((double) zero / (mat.length * mat[1].length));
    }

}
