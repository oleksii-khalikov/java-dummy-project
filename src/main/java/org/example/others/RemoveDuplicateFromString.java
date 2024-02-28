package org.example.others;

public class RemoveDuplicateFromString {
    public static String removeDuplicate(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (sb.toString().indexOf(s.charAt(i)) == -1) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
