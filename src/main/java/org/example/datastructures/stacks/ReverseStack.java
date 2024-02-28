package org.example.datastructures.stacks;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int element = stack.peek();
        stack.pop();

        reverseStack(stack);

        insertAtBottom(stack, element);
    }

    private static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        int ele = stack.peek();
        stack.pop();
        insertAtBottom(stack, element);

        stack.push(ele);
    }
}
