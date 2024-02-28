package org.example.others;

import java.util.Arrays;
import java.util.Comparator;

public class LineSweep {

    public static int FindMaximumEndPoint(int[][] ranges) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[1]));
        return ranges[ranges.length - 1][1];
    }

    public static boolean isOverlap(int[][] ranges) {

        int maximumEndPoint = FindMaximumEndPoint(ranges);
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        int[] numberLine = new int[maximumEndPoint + 2];
        for (int[] range : ranges) {

            int start = range[0];
            int end = range[1];

            numberLine[start] += 1;
            numberLine[end + 1] -= 1;
        }

        int current = 0;
        int overlaps = 0;
        for (int num : numberLine) {
            current += num;
            overlaps = Math.max(overlaps, current);
        }
        return overlaps > 1;
    }
}
