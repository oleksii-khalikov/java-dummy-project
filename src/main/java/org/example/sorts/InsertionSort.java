package org.example.sorts;

import java.util.function.Function;

import static org.example.sorts.SortUtils.less;
import static org.example.sorts.SortUtils.swap;

class InsertionSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        return sort(array, 0, array.length);
    }

    public <T extends Comparable<T>> T[] sort(T[] array, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            for (int j = i; j > lo && less(array[j], array[j - 1]); j--) {
                swap(array, j, j - 1);
            }
        }
        return array;
    }

    public <T extends Comparable<T>> T[] sentinelSort(T[] array) {
        int minElemIndex = 0;
        int n = array.length;
        if (n < 1) return array;
        for (int i = 1; i < n; i++)
            if (less(array[i], array[minElemIndex])) minElemIndex = i;
        swap(array, 0, minElemIndex);

        for (int i = 2; i < n; i++) {
            int j = i;
            T currentValue = array[i];
            while (less(currentValue, array[j - 1])) {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = currentValue;
        }

        return array;
    }

    private static double measureApproxExecTime(Function<Double[], Double[]> sortAlgorithm, Double[] randomArray) {
        long start = System.currentTimeMillis();
        sortAlgorithm.apply(randomArray);
        long end = System.currentTimeMillis();
        return (end - start) / 1000.0;
    }
}
