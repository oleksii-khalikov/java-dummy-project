package org.example.searches;

class HowManyTimesRotated {

    public static int rotated(int[] a) {
        int low = 0;
        int high = a.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) {
                break;
            } else if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1]) {
                high = mid + 1;
            } else if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
                low = mid - 1;
            }
        }

        return mid;
    }
}
