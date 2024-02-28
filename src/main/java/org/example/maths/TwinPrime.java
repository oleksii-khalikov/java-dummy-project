package org.example.maths;

public class TwinPrime {

    static int getTwinPrime(int inputNumber) {

        if (PrimeCheck.isPrime(inputNumber) && PrimeCheck.isPrime(inputNumber + 2)) {
            return inputNumber + 2;
        }
        return -1;
    }
}
