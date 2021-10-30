package com.ip.sylar.dp.lcs;

public class PrintLargestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abe";

        int n = s1.length();

        int m = s2.length();

        System.out.println(printLongestCommonSubstring(s1.toCharArray(), s2.toCharArray(), n, m));
    }

    private static String printLongestCommonSubstring(char[] s1, char[] s2, int n, int m) {
        int[][] t = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        int maxLen = 0;
        int row = 0;
        int col = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                    if (maxLen < t[i][j]) {
                        maxLen = t[i][j];
                        row = i;
                        col = j;
                    }
                }
                else
                {
                    t[i][j] = 0;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (row > 0 && col > 0) {
            stringBuilder = stringBuilder.append(s1[row - 1]);
            row--;
            col--;
        }
        return stringBuilder.reverse().toString();
    }
}
