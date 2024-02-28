package org.example.devutils.searches;

public interface MatrixSearchAlgorithm {
    <T extends Comparable<T>> int[] find(T[][] matrix, T key);
}
