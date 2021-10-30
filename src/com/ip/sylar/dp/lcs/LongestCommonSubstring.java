package com.ip.sylar.dp.lcs;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abce";

        int n = s1.length();

        int m = s2.length();

        System.out.println(findLongestCommonSubstringRec(s1.toCharArray(), s2.toCharArray(), n, m, 0));

        System.out.println(findLongestCommonSubstring(s1.toCharArray(), s2.toCharArray(), n, m));

        System.out.println(findLargestCommonSubstring(s1.toCharArray(), s2.toCharArray(), n, m));
    }

    public static String findLargestCommonSubstring(char[]c1, char[]c2, int m, int n)
    {
        int[][] t = new int[m+1][n+1];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i==0 || j==0)
                {
                    t[i][j] = 0;
                }
            }
        }


        int maxLen = 0;
        int row = 0;
        int col = 0;

        for(int i=1; i<m+1; i++)
        {
            for(int j=1; j<n+1; j++)
            {
                if(c1[i-1] == c2[j-1])
                {
                    t[i][j] = 1 + t[i-1][j-1];
                    if(maxLen < t[i][j])
                    {
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

        StringBuilder str = new StringBuilder();
        while(row>0 && col>0)
        {
            str.append(c1[row-1]);
            row--;
            col--;
        }

        return str.reverse().toString();
    }

    private static int findLongestCommonSubstringRec(char[] s1, char[] s2, int n, int m, int res) {
        if (n == 0 || m == 0) {
            return res;
        }
        if (s1[n - 1] == s2[m - 1]) {
            res = findLongestCommonSubstringRec(s1, s2, n - 1, m - 1, res+1);
            return res;
        }
            res = Math.max(res, Math.max(findLongestCommonSubstringRec(s1, s2, n, m - 1, 0), findLongestCommonSubstringRec(s1, s2, n - 1, m, 0)));
        return res;
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
