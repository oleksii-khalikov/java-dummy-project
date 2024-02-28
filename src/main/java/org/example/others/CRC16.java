package org.example.others;

public class CRC16 {

    public static String crc16(String message) {
        int crc = 0xFFFF;
        int polynomial = 0x1021;
        byte[] bytes = message.getBytes();

        for (byte b : bytes) {
            for (int i = 0; i < 8; i++) {
                boolean bit = ((b >> (7 - i) & 1) == 1);
                boolean c15 = ((crc >> 15 & 1) == 1);
                crc <<= 1;
                if (c15 ^ bit) crc ^= polynomial;
            }
        }
        crc &= 0xffff;
        return Integer.toHexString(crc).toUpperCase();
    }
}
