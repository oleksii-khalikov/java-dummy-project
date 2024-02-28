package org.example.datastructures.stacks;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackArrayList {

    public static void main(String[] args) {
        StackArrayList stack = new StackArrayList();
        assert stack.isEmpty();

        for (int i = 1; i <= 5; ++i) {
            stack.push(i);
            assert stack.size() == i;
        }

        assert stack.size() == 5;
        assert stack.peek() == 5 && stack.pop() == 5 && stack.peek() == 4;

        while (!stack.isEmpty()) {
            stack.pop();
        }
        assert stack.isEmpty();

        try {
            stack.pop();
            assert false;
        } catch (EmptyStackException e) {
            assert true;
        }
    }

    private ArrayList<Integer> stack;

    public StackArrayList() {
        stack = new ArrayList<>();
    }

    public void push(int value) {
        stack.add(value);
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.remove(stack.size() - 1);
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }
    public int size() {
        return stack.size();
    }
}
