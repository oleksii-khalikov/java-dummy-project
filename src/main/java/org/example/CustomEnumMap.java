package org.example;

import java.util.*;

public class CustomEnumMap<K extends Enum<K>, V> extends AbstractMap<K, V> {

    private Class<K> enumType;
    private Object[] values;

    public CustomEnumMap(Class<K> enumType) {
        this.enumType = enumType;
        this.values = new Object[enumType.getEnumConstants().length];
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return new AbstractSet<>() {
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                return new Iterator<>() {
                    int index = -1;

                    @Override
                    public boolean hasNext() {
                        return ++index < values.length;
                    }

                    @Override
                    public Map.Entry<K, V> next() {
                        K key = enumType.getEnumConstants()[index];
                        return new AbstractMap.SimpleEntry<>(key, get(key));
                    }
                };
            }

            @Override
            public int size() {
                return values.length;
            }
        };
    }

    @Override
    public V get(Object key) {
        if (!enumType.isInstance(key)) {
            return null;
        }
        int ordinal = ((Enum<?>) key).ordinal();
        return (V) values[ordinal];
    }

    @Override
    public V put(K key, V value) {
        if (value == null) {
            throw new NullPointerException("Null values not allowed");
        }
        int ordinal = key.ordinal();
        Object oldValue = values[ordinal];
        values[ordinal] = value;
        return (V) oldValue;
    }

    @Override
    public V remove(Object key) {
        if (!enumType.isInstance(key)) {
            return null;
        }
        int ordinal = ((Enum<?>) key).ordinal();
        Object oldValue = values[ordinal];
        values[ordinal] = null;
        return (V) oldValue;
    }

    @Override
    public void clear() {
        Arrays.fill(values, null);
    }

    @Override
    public int size() {
        return values.length;
    }
}
