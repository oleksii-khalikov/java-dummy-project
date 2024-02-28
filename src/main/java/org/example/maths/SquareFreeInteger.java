package org.example.maths;

import java.util.HashSet;
import java.util.List;

public class SquareFreeInteger {
    public static boolean isSquareFreeInteger(int number) {

        if (number <= 0) {
            throw new IllegalArgumentException("Number must be greater than zero.");
        }

        List<Integer> primeFactorsList = PrimeFactorization.pfactors(number);
        return primeFactorsList.size() == new HashSet<>(primeFactorsList).size();
    }
}
