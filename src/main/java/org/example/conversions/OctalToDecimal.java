package org.example.conversions;


public class OctalToDecimal {

    public static int convertOctalToDecimal(String inputOctal) {
        try {
            return Integer.parseInt(inputOctal, 8);
        } catch (NumberFormatException ne) {
            System.out.println("Invalid Input, Expecting octal number 0-7");
            return -1;
        }
    }
}

