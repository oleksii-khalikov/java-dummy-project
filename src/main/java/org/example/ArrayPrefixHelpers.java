package org.example;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class ArrayPrefixHelpers {
    public static void parallelPrefixIntArray(int[] array, IntBinaryOperator operator) {
        Arrays.parallelPrefix(array, operator);
    }

    public static void parallelPrefixIntArrayRange(int[] array, int fromIndex, int toIndex, IntBinaryOperator operator) {
        Arrays.parallelPrefix(array, fromIndex, toIndex, operator);
    }

    public static void fillPrefixSum(int[] array, int[] prefixSum) {
        prefixSum[0] = array[0];
        for (int i = 1; i < array.length; ++i) {
            prefixSum[i] = prefixSum[i - 1] + array[i];
        }
    }

    public static void fillPrefixSumSubarray(int[] array, int start, int end, int[] prefixSum) {
        for (int i = start; i <= end; ++i) {
            prefixSum[i] = prefixSum[i - 1] + array[i];
        }
    }
}
