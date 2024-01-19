package org.example;

import java.util.*;

public class MyCollections {
    public static void addAll(List<String> list, String... items) {
        for (String item : items) {
            list.add(item);
        }
    }

    public static void sort(List<String> list) {
        Collections.sort(list);
    }

    public static int binarySearch(List<String> list, String key) {
        return Collections.binarySearch(list, key);
    }

    public static void copy(List<? super String> dest, List<? extends String> src) {
        Collections.copy(dest, src);
    }

    public static boolean disjoint(Collection<?> c1, Collection<?> c2) {
        return Collections.disjoint(c1, c2);
    }
}
