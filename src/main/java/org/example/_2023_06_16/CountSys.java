package org.example._2023_06_16;

import java.util.ArrayList;
import java.util.List;

public class CountSys {
    public static void main(String[] args) {
        System.out.println(getRadix(2024, 2));
        /**
         * 10 - 202320232
         * 12 - 5790b574
         * 33 - 55jsb4
         */
    }

    private static List<Character> getDigitTable() {
        ArrayList<Character> list = new ArrayList<>();
        for (char i = '0'; i <= '9'; i++) {
            list.add(i);
        }

        for (char i = 'a'; i <= 'z'; i++) {
            list.add(i);
        }
        return list;
    }

    public static String getRadix(int number, int radix) {
        List<Character> list = getDigitTable();

        if(radix < 2 || radix >= list.size() || number <= 0) {
            throw new IllegalArgumentException("Invalid args");
        }

        StringBuilder sb  = new StringBuilder();

        while (number > 0) {
            sb.insert(0, list.get(number % radix));
            number = number / radix;
        }
        return sb.toString();
    }

}
