package org.example.datastructures.trees;

public class FenwickTree {

    private int n;
    private int[] fen_t;

    public FenwickTree(int n) {
        this.n = n;
        this.fen_t = new int[n + 1];
    }
    public void update(int i, int val) {
        i += 1;
        while (i <= n) {
            fen_t[i] += val;
            i += i & (-i);
        }
    }

    public int query(int i) {
        i += 1;
        int cumSum = 0;
        while (i > 0) {
            cumSum += fen_t[i];
            i -= i & (-i);
        }
        return cumSum;
    }
}
