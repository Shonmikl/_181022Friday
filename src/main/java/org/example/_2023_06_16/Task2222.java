package org.example._2023_06_16;

public class Task2222 {
    private static int getOnes(int i) {
        //00001010

        int result = 0;
        //.....
        return result;
    }

    private static int getUnique(int[] array) {
        //[1 2 3 4 1 2 3]
        //[0 0 0 0 0 0 0]
        //[0 0 0 0 0 0 1]
        //[0 0 0 0 0 0 1]//0-1 = 1

        //[0 0 0 0 0 0 1]
        //[0 0 0 0 0 1 0]
        //[0 0 0 0 0 1 1]//1-2 = 3

        //[0 0 0 0 0 1 1]
        //[0 0 0 0 0 1 1]
        //[0 0 0 0 0 0 0]//3-3 = 0

        //[0 0 0 0 0 0 0]
        //[0 0 0 0 1 0 0]
        //[0 0 0 0 1 0 0]//0-4 = 4

        //[0 0 0 0 1 0 0]
        //[0 0 0 0 0 0 1]
        //[0 0 0 0 1 0 1]//4-1 = 5

        //[0 0 0 0 1 0 1]
        //[0 0 0 0 0 1 0]
        //[0 0 0 0 1 1 1]5-2 = 7

        //[0 0 0 0 1 1 1]
        //[0 0 0 0 0 1 1]
        //[0 0 0 0 1 0 0]//7-3 = 4

        int result = 0;
        for (int i : array) {
            result = result ^ i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1, 2, 3};
        System.out.println(getUnique(arr));
    }
}