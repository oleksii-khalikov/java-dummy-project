package org.example.sorts;

public class DutchNationalFlagSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        return dutch_national_flag_sort(unsorted, unsorted[(int) Math.ceil((unsorted.length) / 2.0) - 1]);
    }

    public <T extends Comparable<T>> T[] sort(T[] unsorted, T intendedMiddle) {
        return dutch_national_flag_sort(unsorted, intendedMiddle);
    }

    private <T extends Comparable<T>> T[] dutch_national_flag_sort(T[] arr, T intendedMiddle) {
        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        while (j <= k) {
            if (0 > arr[j].compareTo(intendedMiddle)) {
                SortUtils.swap(arr, i, j);
                j++;
                i++;
            } else if (0 < arr[j].compareTo(intendedMiddle)) {
                SortUtils.swap(arr, j, k);
                k--;
            } else {
                j++;
            }
        }
        return arr;
    }
}
