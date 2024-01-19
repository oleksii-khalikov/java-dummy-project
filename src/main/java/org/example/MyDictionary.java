package org.example;

import java.util.Enumeration;
import java.util.Hashtable;

public class MyDictionary<K, V> {
    private Hashtable<K, V> hashtable;

    public MyDictionary() {
        hashtable = new Hashtable<>();
    }

    public synchronized Enumeration<V> elements() {
        return hashtable.elements();
    }

    public synchronized V get(K key) {
        return hashtable.get(key);
    }

    public synchronized boolean isEmpty() {
        return hashtable.isEmpty();
    }

    public synchronized Enumeration<K> keys() {
        return hashtable.keys();
    }

    public synchronized V put(K key, V value) {
        return hashtable.put(key, value);
    }

    public synchronized V remove(K key) {
        return hashtable.remove(key);
    }

    public synchronized int size() {
        return hashtable.size();
    }
}
