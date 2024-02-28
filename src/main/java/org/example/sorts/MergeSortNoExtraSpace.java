package org.example.sorts;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortNoExtraSpace {

    public static void call_merge_sort(int[] a, int n) {
        int maxele = Arrays.stream(a).max().getAsInt() + 1;
        merge_sort(a, 0, n - 1, maxele);
    }

    public static void merge_sort(int[] a, int start, int end, int maxele) { // this function divides the array into 2 halves
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(a, start, mid, maxele);
            merge_sort(a, mid + 1, end, maxele);
            implement_merge_sort(a, start, mid, end, maxele);
        }
    }

    public static void implement_merge_sort(int[] a, int start, int mid, int end,
        int maxele) {
        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            if (a[i] % maxele <= a[j] % maxele) {
                a[k] = a[k] + (a[i] % maxele) * maxele;
                k++;
                i++;
            } else {
                a[k] = a[k] + (a[j] % maxele) * maxele;
                k++;
                j++;
            }
        }
        while (i <= mid) {
            a[k] = a[k] + (a[i] % maxele) * maxele;
            k++;
            i++;
        }
        while (j <= end) {
            a[k] = a[k] + (a[j] % maxele) * maxele;
            k++;
            j++;
        }
        for (i = start; i <= end; i++) {
            a[i] = a[i] / maxele;
        }
    }
}
