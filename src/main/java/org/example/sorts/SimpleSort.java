package org.example.sorts;

import static org.example.sorts.SortUtils.less;

public class SimpleSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        final int LENGTH = array.length;

        for (int i = 0; i < LENGTH; i++) {
            for (int j = i + 1; j < LENGTH; j++) {
                if (less(array[j], array[i])) {
                    T element = array[j];
                    array[j] = array[i];
                    array[i] = element;
                }
            }
        }

        return array;
    }
}
