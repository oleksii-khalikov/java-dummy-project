package org.example.sorts;

import java.util.Iterator;
import java.util.LinkedList;

public class StrandSort {

    public static <E extends Comparable<? super E>> LinkedList<E> strandSort(LinkedList<E> list) {
        if (list.size() <= 1) return list;

        LinkedList<E> result = new LinkedList<E>();
        while (list.size() > 0) {
            LinkedList<E> sorted = new LinkedList<E>();
            sorted.add(list.removeFirst());
            for (Iterator<E> it = list.iterator(); it.hasNext();) {
                E elem = it.next();
                if (sorted.peekLast().compareTo(elem) <= 0) {
                    sorted.addLast(elem);
                    it.remove();
                }
            }
            result = merge(sorted, result);
        }
        return result;
    }

    private static <E extends Comparable<? super E>> LinkedList<E> merge(LinkedList<E> left, LinkedList<E> right) {
        LinkedList<E> result = new LinkedList<E>();
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.peek().compareTo(right.peek()) <= 0)
                result.add(left.remove());
            else
                result.add(right.remove());
        }
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}
