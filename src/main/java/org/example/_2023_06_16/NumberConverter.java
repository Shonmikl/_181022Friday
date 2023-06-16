package org.example._2023_06_16;

public class NumberConverter {
    public static void main(String[] args) {
        /**
         * 10 - 202320232
         * 12 - 5790b574
         * 33 - 55jsb4
         */
        String result = convertNumber("5790b574", 12, 33);
        System.out.println("Результат: " + result);
    }

    public static String convertNumber(String number, int currentRadix, int targetRadix) {
        int decimalValue = Integer.parseInt(number, currentRadix);
        System.out.println(decimalValue);
        return Integer.toString(decimalValue, targetRadix);
    }
}