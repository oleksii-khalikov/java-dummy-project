package org.example.sorts;

import static org.example.sorts.SortUtils.less;

public class SwapSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int LENGTH = array.length;
        int index = 0;

        while (index < LENGTH - 1) {
            int amountSmallerElements = this.getSmallerElementCount(array, index);

            if (amountSmallerElements > 0 && index != amountSmallerElements) {
                T element = array[index];
                array[index] = array[amountSmallerElements];
                array[amountSmallerElements] = element;
            } else {
                index++;
            }
        }

        return array;
    }

    private <T extends Comparable<T>> int getSmallerElementCount(T[] array, int index) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (less(array[i], array[index])) {
                counter++;
            }
        }

        return counter;
    }
}
