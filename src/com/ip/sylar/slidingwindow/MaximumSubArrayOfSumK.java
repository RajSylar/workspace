package com.ip.sylar.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubArrayOfSumK {
    public static void main(String[] args) {

    }

    public static int findMaxSubarrayLength(int[] arr, int k, int n) {
        int i = 0;
        int j = 0;
        int maxLen = 0;
        int sum = 0;

        while (j < n) {
            sum = sum + arr[j];

            if (sum < k) {
                j++;
            } else if (sum == k) {
                maxLen = Math.max(maxLen, (j - i + 1));
                j++;
            } else {
                while (sum > k) {
                    sum = sum - arr[i];
                    i++;
                }

                if (sum == k) {
                    maxLen = Math.max(maxLen, (j - i + 1));
                }
                j++;
            }
        }

        return maxLen;
    }


    public static int findMaxSubarrayLength2(int[] arr, int k, int n) {
        int maxLen = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];

            if (sum == k) {
                maxLen = i + 1;
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, (i - map.get(sum - k)));
            }
        }

        return maxLen;
    }


}
