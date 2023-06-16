package org.example._2023_06_16;

public class Bit {
    public static void printBinary(int b) {
        System.out.println("0b" + Integer.toBinaryString(0b100000000 | (b & 0xff)).substring(1));
    }

    public static String binaryStr(int b) {
        return "0b" + Integer.toBinaryString(0b100000000 | (b & 0xff)).substring(1);
    }

    public static void main(String[] args) {
        int i = 0b00001000;

        System.out.println("DIGIT: " + i);
        System.out.println("Bit right: " + (i >> 1));
        System.out.println("Bit left: " + (i << 2));
        System.out.println("//////////////////////////////////");

        int a = 0b00001010; // 10
        int b = 0b00010011; // 19

        System.out.println("AND --> &");
        printBinary(a);
        printBinary(b);
        printBinary(a & b);
        System.out.println("//////////////////////////////////");

        System.out.println("OR --> |");
        printBinary(a);
        printBinary(b);
        printBinary(a | b);
        System.out.println("//////////////////////////////////");

        System.out.println("X-OR --> ^");
        printBinary(a);
        printBinary(b);
        printBinary(a ^ b);
        System.out.println("//////////////////////////////////");

        System.out.println("INVERSION --> ^");
        printBinary(a);
        printBinary(~a);
        System.out.println("//////////////////////////////////");
    }
}