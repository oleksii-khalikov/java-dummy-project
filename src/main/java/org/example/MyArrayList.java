package org.example;

import java.util.Arrays;

public class MyArrayList<E> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elementData;
    private int size = 0;

    public MyArrayList() {
        elementData = new Object[INITIAL_CAPACITY];
    }

    public void add(E e) {
        if (size == elementData.length) {
            increaseCapacity();
        }
        elementData[size++] = e;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return (E) elementData[index];
    }

    private void increaseCapacity() {
        int oldLength = elementData.length;
        int newLength = oldLength * 2; // Double the capacity
        elementData = Arrays.copyOf(elementData, newLength);
    }
}
