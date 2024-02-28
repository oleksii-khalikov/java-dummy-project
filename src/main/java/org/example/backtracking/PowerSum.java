package org.example.backtracking;

public class PowerSum {

    private int count = 0, sum = 0;

    public int powSum(int N, int X) {
        Sum(N, X, 1);
        return count;
    }

    public void Sum(int N, int X, int i) {
        if (sum == N) {
            count++;
            return;
        }
        else if (sum + power(i, X) <= N) {
            sum += power(i, X);
            Sum(N, X, i + 1);
            sum -= power(i, X);
        }
        if (power(i, X) < N) {
            Sum(N, X, i + 1);
        }
    }

    private int power(int a, int b) {
        return (int) Math.pow(a, b);
    }
}

