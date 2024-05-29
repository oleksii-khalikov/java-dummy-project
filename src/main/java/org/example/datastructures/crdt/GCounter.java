package org.example.datastructures.crdt;

import java.util.HashMap;
import java.util.Map;

class GCounter {
    private final Map<Integer, Integer> P;
    private final int myId;
    private final int n;

    public GCounter(int myId, int n) {
        this.myId = myId;
        this.n = n;
        this.P = new HashMap<>();

        for (int i = 0; i < n; i++) {
            P.put(i, 0);
        }
    }
    public void increment() {
        P.put(myId, P.get(myId) + 1);
    }

    public int value() {
        int sum = 0;
        for (int v : P.values()) {
            sum += v;
        }
        return sum;
    }

    public boolean compare(GCounter other) {
        for (int i = 0; i < n; i++) {
            if (this.P.get(i) > other.P.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void merge(GCounter other) {
        for (int i = 0; i < n; i++) {
            this.P.put(i, Math.max(this.P.get(i), other.P.get(i)));
        }
    }
}
