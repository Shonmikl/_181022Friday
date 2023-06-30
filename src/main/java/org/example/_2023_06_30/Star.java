package org.example._2023_06_30;

public class Star {
    //P(n, m) = P(n-1, m) + P(n, m - 1)
    public static int getWayNumbers(int n, int m) {
        System.out.println("Rec: [n= " + n + " : m= " + m + " ]");
        if (n < 1 || m < 1) {
            return 0;
        }

        if (n == 1 && m == 1) {
            return 1;
        }
        return getWayNumbers(n - 1, m) + getWayNumbers(n, m - 1);
    }

    public static void main(String[] args) {
        System.out.println(getWayNumbers(3, 4));
    }
}