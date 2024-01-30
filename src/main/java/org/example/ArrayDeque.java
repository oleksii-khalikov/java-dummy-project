package org.example;

public class ArrayDeque<E> {
    private Object[] elements;
    private int head;
    private int tail;

    public ArrayDeque() {
        elements = new Object[16];
        head = 0;
        tail = 0;
    }

    public void addFirst(E e) {
        if (head == 0) {
            resize();
        }
        head--;
        elements[head] = e;
    }

    public void addLast(E e) {
        if (tail == elements.length) {
            resize();
        }
        elements[tail++] = e;
    }

    public E removeFirst() {
        return (E) elements[head++];
    }

    public E removeLast() {
        return (E) elements[--tail];
    }

    public E getFirst() {
        return (E) elements[head];
    }

    public E getLast() {
        return (E) elements[tail - 1];
    }

    private void resize() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, head, newElements, 0, elements.length - head);
        System.arraycopy(elements, 0, newElements, elements.length - head, head);
        elements = newElements;
        head = 0;
        tail = elements.length;
    }
}
