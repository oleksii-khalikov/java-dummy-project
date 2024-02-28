package org.example.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class PasswordGen {

    static String generatePassword(int min_length, int max_length) {
        Random random = new Random();

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*(){}?";

        String allChars = upper + lower + numbers + specialChars;

        List<Character> letters = new ArrayList<Character>();
        for (char c : allChars.toCharArray()) {
            letters.add(c);
        }

        Collections.shuffle(letters);
        StringBuilder password = new StringBuilder();

        for (int i = random.nextInt(max_length - min_length) + min_length; i > 0; --i) {
            password.append(letters.get(random.nextInt(letters.size())));
        }

        return password.toString();
    }
}
