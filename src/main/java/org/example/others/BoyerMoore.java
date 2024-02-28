package org.example.others;

import java.util.Optional;

public final class BoyerMoore {
    private BoyerMoore() {
    }

    public static Optional<Integer> findMajor(final int[] a) {
        final var candidate = findCandidate(a);
        final var count = countOccurrences(candidate, a);
        if (isMajority(count, a.length)) {
            return Optional.of(candidate);
        }
        return Optional.empty();
    }

    private static int findCandidate(final int[] a) {
        int count = 0;
        int candidate = -1;
        for (final var k : a) {
            if (count == 0) {
                candidate = k;
                count = 1;
            } else {
                if (k == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }

    private static int countOccurrences(final int candidate, final int[] a) {
        int count = 0;
        for (final var j : a) {
            if (j == candidate) {
                count++;
            }
        }
        return count;
    }

    private static boolean isMajority(final int count, final int totalCount) {
        return 2 * count > totalCount;
    }
}
