package org.example.sorts;

public class StoogeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsortedArray) {
        sort(unsortedArray, 0, unsortedArray.length);
        return unsortedArray;
    }

    public <T extends Comparable<T>> T[] sort(T[] unsortedArray, int start, int end) {
        if (SortUtils.less(unsortedArray[end - 1], unsortedArray[start])) {
            T temp = unsortedArray[start];
            unsortedArray[start] = unsortedArray[end - 1];
            unsortedArray[end - 1] = temp;
        }

        int len = end - start;
        if (len > 2) {
            int third = len / 3;
            sort(unsortedArray, start, end - third);
            sort(unsortedArray, start + third, end);
            sort(unsortedArray, start, end - third);
        }
        return unsortedArray;
    }


}
