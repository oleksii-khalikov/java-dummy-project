package org.example.maths;


public class PronicNumber {

    static boolean isPronic(int input_number) {
        for (int i = 0; i <= input_number; i++) {
            if (i * (i + 1) == input_number && i != input_number) {
                return true;
            }
        }
        return false;
    }
}
