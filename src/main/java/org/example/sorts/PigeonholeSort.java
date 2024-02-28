package org.example.sorts;

import java.util.ArrayList;

public class PigeonholeSort {

    void sort(Integer[] array) {
        int maxElement = array[0];
        for (int element : array) {
            if (element > maxElement) maxElement = element;
        }

        int numOfPigeonholes = 1 + maxElement;
        ArrayList<Integer>[] pigeonHole = new ArrayList[numOfPigeonholes];

        for (int k = 0; k < numOfPigeonholes; k++) {
            pigeonHole[k] = new ArrayList<>();
        }

        for (int t : array) {
            pigeonHole[t].add(t);
        }

        int k = 0;
        for (ArrayList<Integer> ph : pigeonHole) {
            for (int elements : ph) {
                array[k] = elements;
                k = k + 1;
            }
        }
    }


}
