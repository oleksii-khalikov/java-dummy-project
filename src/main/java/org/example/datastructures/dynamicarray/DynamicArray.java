package org.example.datastructures.dynamicarray;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DynamicArray<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 16;

    private int capacity;
    private int size;
    private Object[] elements;

    public DynamicArray(final int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.elements = new Object[this.capacity];
    }

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public void add(final E element) {
        if (this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, newCapacity(2 * this.capacity));
        }

        this.elements[this.size] = element;
        size++;
    }

    public void put(final int index, E element) {
        this.elements[index] = element;
    }

    public E get(final int index) {
        return getElement(index);
    }

    public E remove(final int index) {
        final E oldElement = getElement(index);
        fastRemove(this.elements, index);

        if (this.capacity > DEFAULT_CAPACITY && size * 4 <= this.capacity) {
            this.elements = Arrays.copyOf(this.elements, newCapacity(this.capacity / 2));
        }
        return oldElement;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Stream<E> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    private void fastRemove(final Object[] elements, final int index) {
        final int newSize = this.size - 1;

        if (newSize > index) {
            System.arraycopy(elements, index + 1, elements, index, newSize - index);
        }

        elements[this.size = newSize] = null;
    }

    private E getElement(final int index) {
        return (E) this.elements[index];
    }

    private int newCapacity(int capacity) {
        this.capacity = capacity;
        return this.capacity;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.stream(this.elements).filter(Objects::nonNull).toArray());
    }

    @Override
    public Iterator iterator() {
        return new DynamicArrayIterator();
    }

    private class DynamicArrayIterator implements Iterator<E> {

        private int cursor;

        @Override
        public boolean hasNext() {
            return this.cursor != size;
        }

        @Override
        public E next() {
            if (this.cursor > DynamicArray.this.size) {
                throw new NoSuchElementException();
            }

            if (this.cursor > DynamicArray.this.elements.length) {
                throw new ConcurrentModificationException();
            }

            final E element = DynamicArray.this.getElement(this.cursor);
            this.cursor++;

            return element;
        }

        @Override
        public void remove() {
            if (this.cursor < 0) {
                throw new IllegalStateException();
            }

            DynamicArray.this.remove(this.cursor);
            this.cursor--;
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);

            for (int i = 0; i < DynamicArray.this.size; i++) {
                action.accept(DynamicArray.this.getElement(i));
            }
        }
    }
}
