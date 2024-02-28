package org.example.bitmanipulation;

public class NumbersDifferentSigns {

    public static boolean differentSigns(int num1, int num2) {
        return (num1 ^ num2) < 0;
    }
}
