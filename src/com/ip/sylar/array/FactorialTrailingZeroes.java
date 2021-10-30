package com.ip.sylar.array;

import java.math.BigDecimal;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(7));
    }

    public static int trailingZeroes(int n) {
        BigDecimal fact = BigDecimal.valueOf(findFactorial(n));
        int fiveCount = 0;
        int twoCount = 0;

        if (fact == BigDecimal.valueOf(0))
            return 0;

        while (fact.intValue()>0) {
            if (fact.remainder(BigDecimal.valueOf(5)).compareTo(BigDecimal.valueOf(0))==0) {
                fiveCount++;
                fact = fact.divide(BigDecimal.valueOf(5));
            }

            if (fact.remainder(BigDecimal.valueOf(2)).compareTo(BigDecimal.valueOf(0))==0) {
                twoCount++;
            }
            fact = fact.divide(BigDecimal.valueOf(2));
        }

        return Math.min(fiveCount, twoCount);
    }

    public static int findFactorial(int n) {
        if (n == 0 || n == 1)
            return 1;

        return n * findFactorial(n - 1);
    }
}
