package com.ip.sylar.leetcode;

import java.util.HashMap;
import java.util.Map;

public class erfd {
    public static int removeDuplicates(int[] nums) {
        int size =0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++)
        {
            int target = nums[i];
            if(map.containsKey(target))
            {
                if(map.get(target)==1)
                    map.put(target, map.get(target)+1);
            }
            else
            {
                map.put(target, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            size = size + entry.getValue();
        }
        return size;
    }

    public static int removeDuplicate(int[] nums) {
        int i = 0;
        for(int n : nums)
        {
            if(i < 2 || n > nums[i - 2])
                nums[i++] = n;
        }
        return i;
    }

    public static void main(String[] args) {
        removeDuplicate(new int[] {1,1,1,2,3,4,4,4,6});
    }
}