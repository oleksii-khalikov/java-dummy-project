package org.example.sorts;

import static org.example.sorts.SortUtils.less;
import static org.example.sorts.SortUtils.swap;

class CombSort implements SortAlgorithm {

    private int nextGap(int gap) {
        gap = (gap * 10) / 13;
        return Math.max(gap, 1);
    }

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int size = arr.length;

        int gap = size;

        boolean swapped = true;

        while (gap != 1 || swapped) {
            gap = nextGap(gap);

            swapped = false;

            for (int i = 0; i < size - gap; i++) {
                if (less(arr[i + gap], arr[i])) {
                    swap(arr, i, i + gap);
                    swapped = true;
                }
            }
        }
        return arr;
    }
}
