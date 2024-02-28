package org.example.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conway {

    private static final StringBuilder builder = new StringBuilder();

    protected static List<String> generateList(String originalString, int maxIteration) {
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < maxIteration; i++) {
            originalString = generateNextElement(originalString);
            numbers.add(originalString);
        }
        return numbers;
    }

    public static String generateNextElement(String originalString) {
        builder.setLength(0);
        String[] stp = originalString.split("(?<=(.))(?!\\1)");
        Arrays.stream(stp).forEach(s -> builder.append(s.length()).append(s.charAt(0)));
        return builder.toString();
    }
}
