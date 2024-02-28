package org.example.dynamicprogramming;


public class KnapsackMemoization {

    int knapSack(int capacity, int[] weights, int[] profits, int numOfItems) {

        int[][] dpTable = new int[numOfItems + 1][capacity + 1];

        for (int i = 0; i < numOfItems + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                dpTable[i][j] = -1;
            }
        }

        return solveKnapsackRecursive(capacity, weights, profits, numOfItems, dpTable);
    }

    int solveKnapsackRecursive(int capacity, int[] weights, int[] profits, int numOfItems, int[][] dpTable) {
        if (numOfItems == 0 || capacity == 0) {
            return 0;
        }
        if (dpTable[numOfItems][capacity] != -1) {
            return dpTable[numOfItems][capacity];
        }
        if (weights[numOfItems - 1] > capacity) {
            dpTable[numOfItems][capacity] = solveKnapsackRecursive(capacity, weights, profits, numOfItems - 1, dpTable);
            return dpTable[numOfItems][capacity];
        } else {
            return dpTable[numOfItems][capacity] = Math.max((profits[numOfItems - 1] + solveKnapsackRecursive(capacity - weights[numOfItems - 1], weights, profits, numOfItems - 1, dpTable)), solveKnapsackRecursive(capacity, weights, profits, numOfItems - 1, dpTable));
        }
    }
}
