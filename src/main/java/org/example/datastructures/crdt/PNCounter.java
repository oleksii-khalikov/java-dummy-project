package org.example.datastructures.crdt;

import java.util.HashMap;
import java.util.Map;

class PNCounter {
    private final Map<Integer, Integer> P;
    private final Map<Integer, Integer> N;
    private final int myId;
    private final int n;

    public PNCounter(int myId, int n) {
        this.myId = myId;
        this.n = n;
        this.P = new HashMap<>();
        this.N = new HashMap<>();

        for (int i = 0; i < n; i++) {
            P.put(i, 0);
            N.put(i, 0);
        }
    }

    public void increment() {
        P.put(myId, P.get(myId) + 1);
    }

    public void decrement() {
        N.put(myId, N.get(myId) + 1);
    }

    public int value() {
        int sumP = P.values().stream().mapToInt(Integer::intValue).sum();
        int sumN = N.values().stream().mapToInt(Integer::intValue).sum();
        return sumP - sumN;
    }

    public boolean compare(PNCounter other) {
        if (this.n != other.n) {
            throw new IllegalArgumentException("Cannot compare PN-Counters with different number of nodes");
        }
        for (int i = 0; i < n; i++) {
            if (this.P.get(i) > other.P.get(i) && this.N.get(i) > other.N.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void merge(PNCounter other) {
        if (this.n != other.n) {
            throw new IllegalArgumentException("Cannot merge PN-Counters with different number of nodes");
        }
        for (int i = 0; i < n; i++) {
            this.P.put(i, Math.max(this.P.get(i), other.P.get(i)));
            this.N.put(i, Math.max(this.N.get(i), other.N.get(i)));
        }
    }
}
