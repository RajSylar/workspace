package com.ip.sylar.recursion;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(findFactorial(n));
    }

    private static int findFactorial(int n) {
        if (n == 0)
        {
            return 1;
        }

        return n* findFactorial(n-1);
    }
}
