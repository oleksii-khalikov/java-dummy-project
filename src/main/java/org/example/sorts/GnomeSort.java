package org.example.sorts;

import static org.example.sorts.SortUtils.less;
import static org.example.sorts.SortUtils.swap;

public class GnomeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int i = 1;
        int j = 2;
        while (i < arr.length) {
            if (less(arr[i - 1], arr[i])) {
                i = j++;
            } else {
                swap(arr, i - 1, i);
                if (--i == 0) {
                    i = j++;
                }
            }
        }

        return null;
    }
}
