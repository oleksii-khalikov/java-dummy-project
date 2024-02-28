package org.example.sorts;

import static org.example.sorts.SortUtils.swap;

public class CircleSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int n = array.length;
        while (doSort(array, 0, n - 1))
            ;
        return array;
    }

    private <T extends Comparable<T>> Boolean doSort(T[] array, int left, int right) {
        boolean swapped = false;

        if (left == right) {
            return false;
        }

        int low = left;
        int high = right;

        while (low < high) {
            if (array[low].compareTo(array[high]) > 0) {
                swap(array, low, high);
                swapped = true;
            }
            low++;
            high--;
        }

        if (low == high && array[low].compareTo(array[high + 1]) > 0) {
            swap(array, low, high + 1);
            swapped = true;
        }

        int mid = left + (right - left) / 2;
        Boolean leftHalf = doSort(array, left, mid);
        Boolean rightHalf = doSort(array, mid + 1, right);

        return swapped || leftHalf || rightHalf;
    }
}
