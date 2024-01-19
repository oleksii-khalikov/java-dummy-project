package org.example;

import java.util.Arrays;

public class MyBitSet {
    private long[] bits;

    public MyBitSet() {
        this.bits = new long[0];
    }

    public void set(int index) {
        ensureCapacity(index);
        bits[index / 64] |= (1L << (index % 64));
    }

    public void clear(int index) {
        ensureCapacity(index);
        bits[index / 64] &= ~(1L << (index % 64));
    }

    public boolean get(int index) {
        ensureCapacity(index);
        return (bits[index / 64] & (1L << (index % 64))) != 0;
    }

    public void flip(int index) {
        ensureCapacity(index);
        bits[index / 64] ^= (1L << (index % 64));
    }

    public int cardinality() {
        int count = 0;
        for (long word : bits) {
            while (word != 0) {
                count++;
                word &= (word - 1);
            }
        }
        return count;
    }

    public void and(MyBitSet other) {
        int minLength = Math.min(bits.length, other.bits.length);
        for (int i = 0; i < minLength; i++) {
            bits[i] &= other.bits[i];
        }
        if (other.bits.length < bits.length) {
            Arrays.fill(bits, minLength, bits.length, 0);
        }
    }

    public void or(MyBitSet other) {
        int maxLength = Math.max(bits.length, other.bits.length);
        if (bits.length < maxLength) {
            bits = Arrays.copyOf(bits, maxLength);
        }
        for (int i = 0; i < other.bits.length; i++) {
            bits[i] |= other.bits[i];
        }
    }

    public void xor(MyBitSet other) {
        int maxLength = Math.max(bits.length, other.bits.length);
        if (bits.length < maxLength) {
            bits = Arrays.copyOf(bits, maxLength);
        }
        for (int i = 0; i < other.bits.length; i++) {
            bits[i] ^= other.bits[i];
        }
    }

    public void andNot(MyBitSet other) {
        int maxLength = Math.max(bits.length, other.bits.length);
        if (bits.length < maxLength) {
            bits = Arrays.copyOf(bits, maxLength);
        }
        for (int i = 0; i < other.bits.length; i++) {
            bits[i] &= ~other.bits[i];
        }
    }

    private void ensureCapacity(int index) {
        if (index >= bits.length * 64) {
            bits = Arrays.copyOf(bits, (index + 64) / 64);
        }
    }
}
