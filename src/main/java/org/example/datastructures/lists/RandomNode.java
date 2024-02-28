/**
 * Author : Suraj Kumar
 * Github : https://github.com/skmodi649
 */

/**
 * PROBLEM DESCRIPTION :
 * There is a single linked list and we are supposed to find a random node in the given linked list
 */

/**
 * ALGORITHM :
 * Step 1 : START
 * Step 2 : Create an arraylist of type integer
 * Step 3 : Declare an integer type variable for size and linked list type for head
 * Step 4 : We will use two methods, one for traversing through the linked list using while loop and
 * also increase the size by 1
 *
 * (a) RandomNode(head)
 * (b) run a while loop till null;
 * (c) add the value to arraylist;
 * (d) increase the size;
 *
 * Step 5 : Now use another method for getting random values using Math.random() and return the
 * value present in arraylist for the calculated index Step 6 : Now in main() method we will simply
 * insert nodes in the linked list and then call the appropriate method and then print the random
 * node generated Step 7 : STOP
 */

package org.example.datastructures.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNode {

    private List<Integer> list;
    private int size;
    private static Random rand = new Random();

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public RandomNode(ListNode head) {
        list = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
            size++;
        }
    }

    public int getRandom() {
        int index = rand.nextInt(size);
        return list.get(index);
    }
}
