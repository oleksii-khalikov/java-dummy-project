package org.example.misc;

import org.example.datastructures.lists.SinglyLinkedList;

import java.util.Stack;

public final class PalindromeSinglyLinkedList {
    private PalindromeSinglyLinkedList() {
    }

    public static boolean isPalindrome(final SinglyLinkedList linkedList) {
        Stack<Integer> linkedListValues = new Stack<>();

        for (final var x : linkedList) {
            linkedListValues.push(x);
        }

        for (final var x : linkedList) {
            if (x != linkedListValues.pop()) {
                return false;
            }
        }

        return true;
    }
}
