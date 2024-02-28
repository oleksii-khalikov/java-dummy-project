package org.example.sorts;

import static org.example.sorts.SortUtils.less;

class CycleSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int n = arr.length;

        for (int j = 0; j <= n - 2; j++) {
            T item = arr[j];

            int pos = j;
            for (int i = j + 1; i < n; i++) {
                if (less(arr[i], item)) {
                    pos++;
                }
            }

            if (pos == j) {
                continue;
            }
            while (item.compareTo(arr[pos]) == 0) {
                pos += 1;
            }

            if (pos != j) {
                item = replace(arr, pos, item);
            }

            while (pos != j) {
                pos = j;

                for (int i = j + 1; i < n; i++) {
                    if (less(arr[i], item)) {
                        pos += 1;
                    }
                }

                while (item.compareTo(arr[pos]) == 0) {
                    pos += 1;
                }

                if (item != arr[pos]) {
                    item = replace(arr, pos, item);
                }
            }
        }

        return arr;
    }

    private <T extends Comparable<T>> T replace(T[] arr, int pos, T item) {
        T temp = item;
        item = arr[pos];
        arr[pos] = temp;
        return item;
    }
}
