package org.example.misc;

public class Sort012D {

    public static void sort012(int[] a) {
        int l = 0;
        int h = a.length - 1;
        int mid = 0;
        int temp;
        while (mid <= h) {
            switch (a[mid]) {
                case 0: {
                    temp = a[l];
                    a[l] = a[mid];
                    a[mid] = temp;
                    l++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = a[mid];
                    a[mid] = a[h];
                    a[h] = temp;
                    h--;
                    break;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
        }
    }
}
