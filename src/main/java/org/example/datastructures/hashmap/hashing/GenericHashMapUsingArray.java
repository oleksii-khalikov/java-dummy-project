package org.example.datastructures.hashmap.hashing;

import java.util.LinkedList;


public class GenericHashMapUsingArray<K, V> {

    private int size;
    private LinkedList<Node>[] buckets;
    private float lf = 0.75f;

    public GenericHashMapUsingArray() {
        initBuckets(16);
        size = 0;
    }

    private void initBuckets(int N) {
        buckets = new LinkedList[N];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int bucketIndex = hashFunction(key);
        LinkedList<Node> nodes = buckets[bucketIndex];
        for (Node node : nodes) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        nodes.add(new Node(key, value));
        size++;

        if ((float) size / buckets.length > lf) {
            reHash();
        }
    }

    private int hashFunction(K key) {
        int hc = key.hashCode();
        return Math.abs(hc) % buckets.length;
    }

    private void reHash() {
        System.out.println("Rehashing!");
        LinkedList<Node>[] old = buckets;
        initBuckets(old.length * 2);
        this.size = 0;

        for (LinkedList<Node> nodes : old) {
            for (Node node : nodes) {
                put(node.key, node.value);
            }
        }
    }

    public void remove(K key) {
        int bucketIndex = hashFunction(key);
        LinkedList<Node> nodes = buckets[bucketIndex];

        Node target = null;
        for (Node node : nodes) {
            if (node.key.equals(key)) {
                target = node;
                break;
            }
        }
        nodes.remove(target);
        size--;
    }

    public int size() {
        return this.size;
    }

    public V get(K key) {
        int bucketIndex = hashFunction(key);
        LinkedList<Node> nodes = buckets[bucketIndex];
        for (Node node : nodes) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("{");
        for (LinkedList<Node> nodes : buckets) {
            for (Node node : nodes) {
                builder.append(node.key);
                builder.append(" : ");
                builder.append(node.value);
                builder.append(", ");
            }
        }
        builder.append("}");
        return builder.toString();
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public class Node {

        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
