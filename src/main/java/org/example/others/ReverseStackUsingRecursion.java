package org.example.others;

import java.util.Stack;

public class ReverseStackUsingRecursion {

    private static Stack<Integer> stack = new Stack<>();

    private static void reverseUsingRecursion(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int temptop = stack.peek();
        stack.pop();
        reverseUsingRecursion(stack);
        insertAtEnd(temptop);
    }

    private static void insertAtEnd(int temptop) {
        if (stack.isEmpty()) {
            stack.push(temptop);
        } else {
            int temp = stack.peek();
            stack.pop();

            insertAtEnd(temptop);

            stack.push(temp);
        }
    }
}
