// Code by Pronay Debnath
// Created:- 1/10/2023
// File Name should be RecursiveBinarySearch.java
// Explanation:- https://www.tutorialspoint.com/java-program-for-binary-search-recursive
package org.example.searches;

import java.util.Scanner;

abstract class SearchAlgorithm<T extends Comparable<T>> {
    public abstract int find(T[] arr, T target);
}

public class RecursiveBinarySearch<T extends Comparable<T>> extends SearchAlgorithm<T> {

    @Override
    public int find(T[] arr, T target) {
        return binsear(arr, 0, arr.length - 1, target);
    }

    public int binsear(T[] arr, int left, int right, T target) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            int comparison = arr[mid].compareTo(target);

            if (comparison == 0) {
                return mid;
            }

            if (comparison > 0) {
                return binsear(arr, left, mid - 1, target);
            }

            return binsear(arr, mid + 1, right, target);
        }

        return -1;
    }
}
