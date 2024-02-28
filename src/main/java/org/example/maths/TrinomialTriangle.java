package org.example.maths;

public class TrinomialTriangle {

    public static int TrinomialValue(int n, int k) {
        if (n == 0 && k == 0) {
            return 1;
        }

        if (k < -n || k > n) {
            return 0;
        }

        return (TrinomialValue(n - 1, k - 1) + TrinomialValue(n - 1, k) + TrinomialValue(n - 1, k + 1));
    }

    public static void printTrinomial(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = -i; j <= 0; j++) {
                System.out.print(TrinomialValue(i, j) + " ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(TrinomialValue(i, j) + " ");
            }

            System.out.println();
        }
    }
}
