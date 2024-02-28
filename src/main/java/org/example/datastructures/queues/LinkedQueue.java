package org.example.datastructures.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class LinkedQueue<T> implements Iterable<T> {

    static class Node<T> {

        T data;
        Node<T> next;

        public Node() {
            this(null);
        }

        public Node(T data) {
            this(data, null);
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> front;

    private Node<T> rear;

    private int size;

    public LinkedQueue() {
        front = rear = new Node<>();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        rear.next = newNode;
        rear = newNode;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        Node<T> destroy = front.next;
        T retValue = destroy.data;
        front.next = front.next.next;
        size--;

        if (isEmpty()) {
            front = rear;
        }

        return retValue;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return front.next.data;
    }

    public T peekRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return rear.data;
    }


    public T peek(int pos) {
        if (pos > size) throw new IndexOutOfBoundsException("Position %s out of range!".formatted(pos));
        Node<T> node = front;
        while (pos-- > 0) node = node.next;
        return node.data;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = front;

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public T next() {
                return (node = node.next).data;
            }
        };
    }

    public int size() {
        return size;
    }

    public void clear() {
        while (size > 0) dequeue();
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", "); // separator of ', '
        Node<T> travel = front;
        while ((travel = travel.next) != null) join.add(String.valueOf(travel.data));
        return '[' + join.toString() + ']';
    }
}
