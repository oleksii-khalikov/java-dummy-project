package org.example.sorts;

import static org.example.sorts.SortUtils.flip;
import static org.example.sorts.SortUtils.less;

public class PancakeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int size = array.length;

        for (int i = 0; i < size; i++) {
            T max = array[0];
            int index = 0;
            for (int j = 0; j < size - i; j++) {
                if (less(max, array[j])) {
                    max = array[j];
                    index = j;
                }
            }
            flip(array, index, array.length - 1 - i);
        }
        return array;
    }


}
