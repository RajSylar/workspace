package com.ip.sylar.dp.lcs;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";

        int n = s1.length();

        int m = s2.length();

        System.out.println(findLongestCommonSubsequenceRec(s1.toCharArray(), s2.toCharArray(), n, m));
        int[][] t = new int[n + 1][m + 1];
        initialize(t);
        System.out.println(findLongestCommonSubMemoized(s1.toCharArray(), s2.toCharArray(), n, m, t));

        System.out.println(findLongestCommonSubDP(s1.toCharArray(), s2.toCharArray(), n, m));
    }

    private static int findLongestCommonSubDP(char[] s1, char[] s2, int n, int m) {
        int[][] t = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }
        return t[n][m];
    }

    private static void initialize(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                t[i][j] = -1;
            }
        }
    }

    private static int findLongestCommonSubsequenceRec(char[] s1, char[] s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (s1[n - 1] == s2[n - 1]) {
            return 1 + findLongestCommonSubsequenceRec(s1, s2, n - 1, m - 1);
        } else {
            return Math.max(findLongestCommonSubsequenceRec(s1, s2, n, m - 1), findLongestCommonSubsequenceRec(s1, s2, n - 1, m));
        }
    }

    private static int findLongestCommonSubMemoized(char[] s1, char[] s2, int n, int m, int[][] t) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (t[n][m] != -1) {
            return t[n][m];
        }

        if (s1[n - 1] == s2[m - 1]) {
            t[n][m] = 1 + findLongestCommonSubMemoized(s1, s2, n - 1, m - 1, t);
        } else {
            t[n][m] = Math.max(findLongestCommonSubMemoized(s1, s2, n, m - 1, t), findLongestCommonSubMemoized(s1, s2, n - 1, m, t));
        }
        return t[n][m];
    }
}
