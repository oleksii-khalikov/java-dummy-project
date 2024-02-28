package org.example.searches;

public class OrderAgnosticBinarySearch {

    static int BinSearchAlgo(int[] arr, int start, int end, int target) {

        boolean AscOrd = arr[start] < arr[end];

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (arr[middle] == target) return middle; // returns the index of the middle element

            if (AscOrd) {
                if (arr[middle] < target) start = middle + 1;
                else end = middle - 1;
            }

            else {
                if (arr[middle] > target) start = middle + 1;
                else end = middle - 1;
            }
        }
        return -1;
    }
}
