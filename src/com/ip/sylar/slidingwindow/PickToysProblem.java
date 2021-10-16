package com.ip.sylar.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PickToysProblem {
    public static void main(String[] args) {

    }

    public static int findUniqueToys(char[] s, int k, int n) {
        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;

        int maxLen = 0;

        while (j < n) {
            if (map.containsKey(s[j])) {
                map.put(s[j], map.get(s[j]) + 1);
            } else {
                map.put(s[j], 1);
            }

            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else {
                while (map.size() > k) {
                    if (map.get(s[i]) > 0) {
                        map.put(s[i], map.get(s[i]) - 1);
                        if (map.get(s[i]) == 0) {
                            map.remove(s[i]);
                        }
                        i++;
                    }
                }
                j++;
            }
        }
        return maxLen;
    }
}
