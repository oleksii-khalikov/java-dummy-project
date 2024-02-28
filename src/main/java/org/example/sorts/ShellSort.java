package org.example.sorts;

import static org.example.sorts.SortUtils.less;

public class ShellSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int length = array.length;
        int gap = 1;

        while (gap < length / 3) {
            gap = 3 * gap + 1;
        }

        for (; gap > 0; gap /= 3) {
            for (int i = gap; i < length; i++) {
                int j;
                T temp = array[i];
                for (j = i; j >= gap && less(temp, array[j - gap]); j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
        return array;
    }

}
