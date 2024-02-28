package org.example.sorts;

import org.example.datastructures.trees.BSTRecursiveGeneric;

import java.util.List;

public class TreeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsortedArray) {
        return doTreeSortArray(unsortedArray);
    }

    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> unsortedList) {
        return doTreeSortList(unsortedList);
    }

    private <T extends Comparable<T>> T[] doTreeSortArray(T[] unsortedArray) {
        BSTRecursiveGeneric<T> tree = new BSTRecursiveGeneric<T>();
        for (T element : unsortedArray) {
            tree.add(element);
        }
        List<T> sortedList = tree.inorderSort();
        int i = 0;
        for (T element : sortedList) {
            unsortedArray[i++] = element;
        }
        return unsortedArray;
    }

    private <T extends Comparable<T>> List<T> doTreeSortList(List<T> unsortedList) {
        BSTRecursiveGeneric<T> tree = new BSTRecursiveGeneric<T>();
        for (T element : unsortedList) {
            tree.add(element);
        }
        return tree.inorderSort();
    }

}
