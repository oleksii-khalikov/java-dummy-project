package org.example.others;

public class BrianKernighanAlgorithm {

    static int countSetBits(int num) {
        int cnt = 0;
        while (num != 0) {
            num = num & (num - 1);
            cnt++;
        }
        return cnt;
    }
}
