package org.example.datastructures.lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_K_SortedLinkedlist {

    Node mergeKList(Node[] a, int N) {
        PriorityQueue<Node> min = new PriorityQueue<>(Comparator.comparingInt(x -> x.data));

        min.addAll(Arrays.asList(a).subList(0, N));

        Node head = min.poll();
        min.add(head.next);
        Node curr = head;

        while (!min.isEmpty()) {
            Node temp = min.poll();
            curr.next = temp;
            curr = temp;

            if (temp.next != null) {
                min.add(temp.next);
            }
        }

        return head;
    }

    private class Node {

        private int data;
        private Node next;
    }
}
