package com.ip.sylar.dp.lcs;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int n = s1.length();
        int m = s2.length();

        int lcs = findLCS(s1.toCharArray(), s2.toCharArray(), n, m);

        System.out.println(n + m - lcs);

        System.out.println(findSCS(s1.toCharArray(), s2.toCharArray(), n, m));
    }

    private static String findSCS(char[] s1, char[] s2, int n, int m) {
        int[][] t = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    t[i][j] = j;
                } else if (j == 0) {
                    t[i][j] = i;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = 1 + Math.min(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        StringBuilder str = new StringBuilder();
        while (n > 0 && m > 0) {
            if (s1[n - 1] == s2[m - 1]) {
                str = str.append(s1[n - 1]);
                n--;
                m--;
            } else {
                if (t[n - 1][m] > t[n][m - 1]) {
                    str = str.append(s2[m - 1]);
                    m--;
                } else {
                    str = str.append(s1[n - 1]);
                    n--;
                }
            }
        }

        while (n > 0) {
            str.append(s1[n - 1]);
            n--;
        }

        while (m > 0) {
            str.append(s2[m - 1]);
            m--;
        }

        return str.reverse().toString();
    }

    private static int findLCS(char[] s1, char[] s2, int n, int m) {
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
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        return t[n][m];
    }
}
