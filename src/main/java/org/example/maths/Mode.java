package org.example.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Mode {
    public static int[] mode(int[] numbers) {
        if (numbers.length == 0) {
            return null;
        }

        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : numbers) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }

        int max = Collections.max(count.values());
        ArrayList<Integer> modes = new ArrayList<>();

        for (int num : count.keySet()) {
            if (count.get(num) == max) {
                modes.add(num);
            }
        }
        return modes.stream().mapToInt(n -> n).toArray();
    }
}
