package com.ip.sylar.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNoRepeatingChar {
    public static void main(String[] args) {
        String s = "pwwkew";
        int n = s.length();

        System.out.println(findAllUniqueLongestSubString(s.toCharArray(), n));
    }

    private static int findAllUniqueLongestSubString(char[] s, int n) {
        Set<Character> set = new HashSet<>();

        int i = 0;
        int j = 0;
        int maxLen = 0;
        while (j < n) {
            if (set.add(s[j])) {
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else {
                while (!set.add(s[j])) {
                    set.remove(s[i]);
                    i++;
                }
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            }
        }
        return maxLen;
    }
}
