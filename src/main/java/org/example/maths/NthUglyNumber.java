package org.example.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NthUglyNumber {
    private ArrayList<Long> uglyNumbers = new ArrayList<>(Arrays.asList(1L));
    private final int[] baseNumbers;
    private HashMap<Integer, Integer> positions = new HashMap<>();

    NthUglyNumber(final int[] baseNumbers) {
        if (baseNumbers.length == 0) {
            throw new IllegalArgumentException("baseNumbers must be non-empty.");
        }

        this.baseNumbers = baseNumbers;
        for (final var baseNumber : baseNumbers) {
            this.positions.put(baseNumber, 0);
        }
    }

    public Long get(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative.");
        }

        while (uglyNumbers.size() <= n) {
            addUglyNumber();
        }

        return uglyNumbers.get(n);
    }

    private void addUglyNumber() {
        uglyNumbers.add(computeMinimalCandidate());
        updatePositions();
    }

    private void updatePositions() {
        final var lastUglyNumber = uglyNumbers.get(uglyNumbers.size() - 1);
        for (final var baseNumber : baseNumbers) {
            if (computeCandidate(baseNumber) == lastUglyNumber) {
                positions.put(baseNumber, positions.get(baseNumber) + 1);
            }
        }
    }

    private long computeCandidate(final int candidateBase) {
        return candidateBase * uglyNumbers.get(positions.get(candidateBase));
    }

    private long computeMinimalCandidate() {
        long res = Long.MAX_VALUE;
        for (final var baseNumber : baseNumbers) {
            res = Math.min(res, computeCandidate(baseNumber));
        }
        return res;
    }
}
