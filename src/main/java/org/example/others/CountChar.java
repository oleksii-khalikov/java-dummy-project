package org.example.others;

public class CountChar {

    public static int CountCharacters(String str) {
        return str.replaceAll("\\s", "").length();
    }
}
