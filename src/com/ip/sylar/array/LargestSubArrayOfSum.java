package com.ip.sylar.array;

import java.util.HashMap;

public class LargestSubArrayOfSum {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 2, 7, 1, 9};
        int targetSum = 15;
        int largest = lenOfLongSubarr(arr, targetSum, arr.length);
        System.out.println(largest);
    }

    static int lenOfLongSubarr(int[] arr, int k, int n) {
        // HashMap to store (sum, index) tuples
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        // traverse the given array
            for (int i = 0; i < n; i++) {

            // accumulate sum
            sum += arr[i];

            // when subarray starts from index '0'
            if (sum == k)
                maxLen = i + 1;

            // make an entry for 'sum' if it is
            // not present in 'map'
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            // check if 'sum-k' is present in 'map'
            // or not
            if (map.containsKey(sum - k)) {

                // update maxLength
                if (maxLen < (i - map.get(sum - k)))
                    maxLen = i - map.get(sum - k);
            }
        }

        return maxLen;
    }

    private static int findLargestSubArrayOfSum(int[] arr, int target, int n) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int maxArrayLen = 0;
        while (j < n) {
            sum = sum + arr[j];
            if (sum < target) {
                j++;
            } else if (sum == target) {
                maxArrayLen = Math.max(maxArrayLen, (j - i + 1));
                j++;
            } else if (sum > target) {
                while (sum > target) {
                    sum = sum - arr[i];
                    i++;
                }
                if (sum == target) {
                    maxArrayLen = Math.max(maxArrayLen, (j - i + 1));
                }
                j++;
            }
        }
        return maxArrayLen;
    }
}
