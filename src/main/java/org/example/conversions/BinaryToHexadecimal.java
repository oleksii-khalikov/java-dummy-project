package org.example.conversions;

import java.util.HashMap;

public class BinaryToHexadecimal {
    static String binToHex(int binary) {
        HashMap<Integer, String> hm = new HashMap<>();
        String hex = "";
        int i;
        for (i = 0; i < 10; i++) {
            hm.put(i, String.valueOf(i));
        }
        for (i = 10; i < 16; i++) {
            hm.put(i, String.valueOf((char) ('A' + i - 10)));
        }
        int currbit;
        while (binary != 0) {
            int code4 = 0;
            for (i = 0; i < 4; i++) {
                currbit = binary % 10;
                binary = binary / 10;
                code4 += currbit * (int) Math.pow(2, i);
            }
            hex = hm.get(code4) + hex;
        }
        return hex;
    }

}

