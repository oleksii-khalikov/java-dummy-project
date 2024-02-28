package org.example.sorts;

public class DNFSort {

    static void sort012(int[] a, int arr_size) {
        int low = 0;
        int high = arr_size - 1;
        int mid = 0, temp = 0;
        while (mid <= high) {
            switch (a[mid]) {
                case 0: {
                    temp = a[low];
                    a[low] = a[mid];
                    a[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = a[mid];
                    a[mid] = a[high];
                    a[high] = temp;
                    high--;
                    break;
                }
            }
        }
    }
}
