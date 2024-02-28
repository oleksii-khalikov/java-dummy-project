package org.example.datastructures.heaps;

import java.util.ArrayList;


public class LeftistHeap {
    private class Node {
        private int element, npl;
        private Node left, right;

        private Node(int element) {
            this.element = element;
            left = right = null;
            npl = 0;
        }
    }

    private Node root;

    public LeftistHeap() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public void merge(LeftistHeap h1) {
        root = merge(root, h1.root);
        h1.root = null;
    }

    public Node merge(Node a, Node b) {
        if (a == null) return b;

        if (b == null) return a;

        if (a.element > b.element) {
            Node temp = a;
            a = b;
            b = temp;
        }

        a.right = merge(a.right, b);

        if (a.left == null) {
            a.left = a.right;
            a.right = null;
        } else {
            if (a.left.npl < a.right.npl) {
                Node temp = a.left;
                a.left = a.right;
                a.right = temp;
            }
            a.npl = a.right.npl + 1;
        }
        return a;
    }

    public void insert(int a) {
        root = merge(new Node(a), root);
    }

    public int extract_min() {
        if (isEmpty()) return -1;

        int min = root.element;
        root = merge(root.left, root.right);
        return min;
    }

    public ArrayList<Integer> in_order() {
        ArrayList<Integer> lst = new ArrayList<>();
        in_order_aux(root, lst);
        return new ArrayList<>(lst);
    }

    private void in_order_aux(Node n, ArrayList<Integer> lst) {
        if (n == null) return;
        in_order_aux(n.left, lst);
        lst.add(n.element);
        in_order_aux(n.right, lst);
    }
}
