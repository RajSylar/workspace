package com.ip.sylar.dp.lcs;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abce";

        int n = s1.length();

        int m = s2.length();

        //System.out.println(findLongestCommonSubstringRec(s1.toCharArray(), s2.toCharArray(), n, m, 0));

        System.out.println(findLongestCommonSubstring(s1.toCharArray(), s2.toCharArray(), n, m));
    }

    private static int findLongestCommonSubstringRec(char[] s1, char[] s2, int n, int m, int res) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (s1[n - 1] == s2[m - 1]) {
            res = 1+ findLongestCommonSubstringRec(s1, s2, n - 1, m - 1, res);
            return res;
        } else {
            return Math.max(findLongestCommonSubstringRec(s1, s2, n, m - 1, 0), findLongestCommonSubstringRec(s1, s2, n - 1, m, 0));
        }
    }

    private static int findLongestCommonSubstring(char[] s1, char[] s2, int n, int m) {
        int[][] t = new int[n + 1][m + 1];
        int res = 0;

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
                    res = Math.max(res, t[i][j]);
                } else {
                    t[i][j] = 0;
                }
            }
        }
        return res;
    }
}
