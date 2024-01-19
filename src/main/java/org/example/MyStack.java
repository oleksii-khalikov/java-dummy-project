package org.example;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyStack {
    private Object[] elements;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 16;

    public MyStack() {
        elements = new Object[INITIAL_CAPACITY];
    }

    public void push(Object item) {
        ensureCapacity();
        elements[size++] = item;
    }

    public Object pop() {
        if (size == 0) throw new NoSuchElementException("Stack is empty");
        return elements[--size];
    }

    public Object peek() {
        if (size == 0) throw new NoSuchElementException("Stack is empty");
        return elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }
}
