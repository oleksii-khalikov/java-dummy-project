package org.example.datastructures.queues;

public class CircularQueue {

    int[] arr;
    int topOfQueue;
    int beginningOfQueue;
    int size;

    public CircularQueue(int size) {
        arr = new int[size];
        topOfQueue = -1;
        beginningOfQueue = -1;
        this.size = size;
    }

    public boolean isEmpty() {
        return beginningOfQueue == -1;
    }

    public boolean isFull() {
        if (topOfQueue + 1 == beginningOfQueue) {
            return true;
        } else
            return topOfQueue == size - 1 && beginningOfQueue == 0;
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("The Queue is full!");
        } else if (isEmpty()) {
            beginningOfQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println(value + " has been successfully inserted!");
        } else {
            if (topOfQueue + 1 == size) {
                topOfQueue = 0;
            } else {
                topOfQueue++;
            }
            arr[topOfQueue] = value;
            System.out.println(value + " has been successfully inserted!");
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("The Queue is Empty!");
            return -1;
        } else {
            int res = arr[beginningOfQueue];
            arr[beginningOfQueue] = Integer.MIN_VALUE;
            if (beginningOfQueue == topOfQueue) {
                beginningOfQueue = topOfQueue = -1;
            } else if (beginningOfQueue + 1 == size) {
                beginningOfQueue = 0;
            } else {
                beginningOfQueue++;
            }
            return res;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("The Queue is Empty!");
            return -1;
        } else {
            return arr[beginningOfQueue];
        }
    }

    public void deleteQueue() {
        arr = null;
        System.out.println("The Queue is deleted!");
    }
}
