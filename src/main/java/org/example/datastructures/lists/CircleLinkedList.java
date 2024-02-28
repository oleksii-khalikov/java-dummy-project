package org.example.datastructures.lists;

public class CircleLinkedList<E> {

    private static class Node<E> {

        Node<E> next;
        E value;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int size;
    private Node<E> head = null;
    private Node<E> tail = null;

    public CircleLinkedList() {
        head = new Node<E>(null, head);
        tail = head;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void append(E value) {
        if (value == null) {
            throw new NullPointerException("Cannot add null element to the list");
        }
        if (tail == null) {
            tail = new Node<E>(value, head);
            head.next = tail;
        } else {
            tail.next = new Node<E>(value, head);
            tail = tail.next;
        }
        size++;
    }

    public String toString() {
        Node p = head.next;
        String s = "[ ";
        while (p != head) {
            s += p.value;
            if (p != tail) {
                s += " , ";
            }
            p = p.next;
        }
        return s + " ]";
    }

    public E remove(int pos) {
        if (pos > size || pos < 0) {
            throw new IndexOutOfBoundsException("position cannot be greater than size or negative");
        }
        Node<E> before = head;
        for (int i = 1; i <= pos; i++) {
            before = before.next;
        }
        Node<E> destroy = before.next;
        E saved = destroy.value;
        before.next = before.next.next;
        if (destroy == tail) {
            tail = before;
        }
        destroy = null;
        size--;
        return saved;
    }
}
