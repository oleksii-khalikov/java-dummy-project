package org.example.backtracking;

import java.util.*;

public class Combination {

    private static int length;
    public static <T> List<TreeSet<T>> combination(T[] arr, int n) {
        if (n == 0) {
            return null;
        }
        length = n;
        T[] array = arr.clone();
        Arrays.sort(array);
        List<TreeSet<T>> result = new LinkedList<>();
        backtracking(array, 0, new TreeSet<T>(), result);
        return result;
    }
    private static <T> void backtracking(T[] arr, int index, TreeSet<T> currSet, List<TreeSet<T>> result) {
        if (index + length - currSet.size() > arr.length) return;
        if (length - 1 == currSet.size()) {
            for (int i = index; i < arr.length; i++) {
                currSet.add(arr[i]);
                result.add((TreeSet<T>) currSet.clone());
                currSet.remove(arr[i]);
            }
        }
        for (int i = index; i < arr.length; i++) {
            currSet.add(arr[i]);
            backtracking(arr, i + 1, currSet, result);
            currSet.remove(arr[i]);
        }
    }
}
