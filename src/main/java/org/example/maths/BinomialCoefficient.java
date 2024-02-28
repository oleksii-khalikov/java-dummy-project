package org.example.maths;


public class BinomialCoefficient {


    public static int binomialCoefficient(int totalObjects, int numberOfObjects) {
        if (numberOfObjects > totalObjects) {
            return 0;
        }

        if (numberOfObjects == 0 || numberOfObjects == totalObjects) {
            return 1;
        }

        return (binomialCoefficient(totalObjects - 1, numberOfObjects - 1) + binomialCoefficient(totalObjects - 1, numberOfObjects));
    }
}
