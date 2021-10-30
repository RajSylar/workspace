package com.ip.sylar.dp.unboundedknapsack;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int length[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int N = 8;
        int n = length.length;
        System.out.println(rodCuttingRecur(length, price, N, n));
        System.out.println(rodCutting(length, price, N, n));
        System.out.println(rodCuttingProblem(price, length, N, n));
        System.out.println(rodCuttingProb(price, length, N, n));
    }

    private static int rodCuttingRecur(int[] length, int[] price, int N, int n) {
        if (n == 0 || N == 0) {
            return 0;
        }

        if (length[n - 1] <= N) {
            return Math.max(price[n - 1] + rodCuttingRecur(length, price, N - length[n - 1], n), rodCuttingRecur(length, price, N, n - 1));
        } else {
            return rodCuttingRecur(length, price, N, n - 1);
        }

    }

    public static int rodCuttingProblem(int[] price, int[] length, int len, int n) {
        if (n == 0 || len == 0)
            return 0;


        if (length[n - 1] <= len) {
            return Math.max(price[n - 1] + rodCuttingProblem(price, length, len - length[n - 1], n - 1), rodCuttingProblem(price, length, len, n - 1));
        } else {
            return rodCuttingProblem(price, length, len, n - 1);
        }
    }

    public static int rodCuttingProb(int[] price, int[] length, int len, int n)
    {
        int[][] t = new int[n+1][len+1];

        for(int i=0; i<n+1; i++)
        {
            for(int j=0; j<len+1; j++)
            {
                if(i==0 || j==0)
                {
                    t[i][j] = 0;
                }
            }
        }

        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<len+1; j++)
            {
                if(length[i-1]<=j)
                {
                    t[i][j] = Math.max(price[i-1] + t[i][j- length[i-1]], t[i-1][j]);
                }
                else
                {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][len];
    }

    private static int rodCutting(int[] length, int[] price, int N, int n) {
        int[][] t = new int[n + 1][N + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (length[i - 1] <= j) {
                    t[i][j] = Math.max(price[i - 1] + t[i][j - length[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][N];
    }
}
