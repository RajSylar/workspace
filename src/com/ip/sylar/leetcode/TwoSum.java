package com.ip.sylar.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        int[] arr = new int[2];
        for(int i=0; i<nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                index = map.get(nums[i]);
                arr[0]=index;
                arr[1]= i;
            }
            else
            {
                map.put(target-nums[i], i);
            }
        }
        return  arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        System.out.println(twoSum(arr, 9));
    }
}