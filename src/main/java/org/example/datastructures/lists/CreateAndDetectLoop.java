package org.example.datastructures.lists;

import java.util.Scanner;

public class CreateAndDetectLoop {

    static void printList(Node head) {
        Node cur = head;

        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }

    static void createLoop(Node head, int k) {
        if (head == null) {
            return;
        }
        Node temp = head;
        int count = 1;
        while (count < k) {
            temp = temp.next;
            count++;
        }

        Node connectedPoint = temp;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = connectedPoint;
    }

    static boolean detectLoop(Node head) {
        Node sptr = head;
        Node fptr = head;

        while (fptr != null && fptr.next != null) {
            sptr = sptr.next;
            fptr = fptr.next.next;
            if (fptr == sptr) {
                return true;
            }
        }

        return false;
    }
}
