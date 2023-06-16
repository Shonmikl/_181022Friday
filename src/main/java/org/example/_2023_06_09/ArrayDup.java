package org.example._2023_06_09;

import java.util.Objects;
import java.util.logging.Handler;

public class ArrayDup {
    private static int searchDuplicated(int[] arr) {
        //[1 2 1 3 1 1]
        //[0 0 0 0 0 0 0 0]

        //[0 0 0 0 0 0 0 1]
        //[0 0 0 0 0 0 1 0]

        //[0 0 1 0 1 0 1 1] 43
        //[0 0 1 1 1 1 1 0] 62
        //[0 0 0 1 0 1 0 1] 21

        int xor = 0;
        for (int i : arr) {
            xor = xor ^ i;
        }
        return xor;
    }

    public static int findUniqueNumber(int[] arr) {
        for (int k : arr) {
            int count = 0;
            for (int i : arr) {
                if (k == i) {
                    count++;
                }
            }
            if (count == 1) {
                return k;
            }
        }
        return -1;
    }

    private static int bitCount(int n) {
        int result = 0;
        /**
         * int n = 3;
         * 0 0 0 0 . 0 0 1 1
         * HW &
         * 0 0 0 0 0 1 0 0
         * 0 0 0 0 0 0 1 1
         * 0 0 0 0 0 0 0 0
         */

        while (n != 0) {
            n = n & (n-1); //n = 4 & (4-1==3)
            result++;// 1 1 1
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] a = {77, 88, 1, 2, 3, 1, 2, 3, 77};
//        System.out.println(searchDuplicated(a));
        // System.out.println(43 ^ 62);
        System.out.println(Integer.toBinaryString(1999999999));
//
        int n = 0b00001111;
        System.out.println(bitCount(n));
        char c = 'A';
        c++;
        System.out.println(c);
    }
}
