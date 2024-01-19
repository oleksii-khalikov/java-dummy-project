package org.example;

import java.io.Serializable;
import java.util.*;

public class MyHashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable {
    private HashMap<E, Boolean> map;
    public MyHashSet() {
        map = new HashMap<>();
    }

    public MyHashSet(Collection<? extends E> c) {
        map = new HashMap<>();
        addAll(c);
    }

    public MyHashSet(int initialCapacity) {
        map = new HashMap<>(initialCapacity);
    }

    public MyHashSet(int initialCapacity, float loadFactor) {
        map = new HashMap<>(initialCapacity, loadFactor);
    }
    @Override
    public boolean add(E e) {
        return map.put(e, Boolean.TRUE) == null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public int size() {
        return map.size();
    }

}
