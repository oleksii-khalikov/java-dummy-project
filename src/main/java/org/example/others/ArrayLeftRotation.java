package org.example.others;


public class ArrayLeftRotation {

    public static int[] rotateLeft(int[] arr, int n) {
        int size = arr.length;
        int[] dst = new int[size];
        n = n % size;
        for (int i = 0; i < size; i++) {
            dst[i] = arr[n];
            n = (n + 1) % size;
        }
        return dst;
    }
}
