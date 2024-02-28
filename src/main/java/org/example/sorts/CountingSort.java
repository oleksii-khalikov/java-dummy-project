package org.example.sorts;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

class CountingSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        return sort(Arrays.asList(unsorted)).toArray(unsorted);
    }

    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> list) {
        Map<T, Integer> frequency = new TreeMap<>();
        List<T> sortedArray = new ArrayList<>(list.size());

        list.forEach(v -> frequency.put(v, frequency.getOrDefault(v, 0) + 1));

        for (Map.Entry<T, Integer> element : frequency.entrySet()) {
            for (int j = 0; j < element.getValue(); j++) {
                sortedArray.add(element.getKey());
            }
        }

        return sortedArray;
    }

    private static <T extends Comparable<T>> List<T> streamSort(List<T> list) {
        return list.stream().collect(toMap(k -> k, v -> 1, (v1, v2) -> v1 + v2, TreeMap::new)).entrySet().stream().flatMap(entry -> IntStream.rangeClosed(1, entry.getValue()).mapToObj(t -> entry.getKey())).collect(toList());
    }
}
