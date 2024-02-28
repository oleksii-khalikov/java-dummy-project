package org.example.datastructures.bags;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Element> implements Iterable<Element> {

    private Node<Element> firstElement;
    private int size;

    private static class Node<Element> {

        private Element content;
        private Node<Element> nextElement;
    }

    public Bag() {
        firstElement = null;
        size = 0;
    }

    public boolean isEmpty() {
        return firstElement == null;
    }

    public int size() {
        return size;
    }

    public void add(Element element) {
        Node<Element> oldfirst = firstElement;
        firstElement = new Node<>();
        firstElement.content = element;
        firstElement.nextElement = oldfirst;
        size++;
    }

    public boolean contains(Element element) {
        for (Element value : this) {
            if (value.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<Element> iterator() {
        return new ListIterator<>(firstElement);
    }

    @SuppressWarnings("hiding")
    private class ListIterator<Element> implements Iterator<Element> {

        private Node<Element> currentElement;

        public ListIterator(Node<Element> firstElement) {
            currentElement = firstElement;
        }

        public boolean hasNext() {
            return currentElement != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Element next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Element element = currentElement.content;
            currentElement = currentElement.nextElement;
            return element;
        }
    }
}
