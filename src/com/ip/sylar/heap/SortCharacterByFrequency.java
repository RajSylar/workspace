package com.ip.sylar.heap;

import java.util.*;

public class SortCharacterByFrequency {
    public static void main(String[] args) {
        String s = "eeeetttr";
        System.out.println((topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
    }
    static class Pair
    {
        int freq;
        int val;

        public Pair(int freq, int val)
        {
            this.freq = freq;
            this.val = val;
        }

        public int getFreq()
        {
            return this.freq;
        }

//        public char getVal()
//        {
//            return this.val;
//        }


    }
//    public static String frequencySort(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        char[] arr = s.toCharArray();
//        for(int i=0; i<arr.length; i++)
//        {
//            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
//        }
//
//        Comparator<Pair> comp = Comparator.comparing(Pair::getFreq).reversed();
//        PriorityQueue<Pair> queue = new PriorityQueue<>(comp);
//
//        for(Map.Entry<Character, Integer> entry : map.entrySet())
//        {
//            queue.add(new Pair(entry.getValue(), entry.getKey()));
//        }
//
//        StringBuilder str = new StringBuilder();
//
//        while(!queue.isEmpty())
//        {
//            Pair pair = queue.peek();
//            for(int i=0; i<pair.freq; i++)
//            {
//                str.append(pair.val);
//            }
//            queue.poll();
//        }
//
//        return str.toString();
//    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }


        Comparator<Pair> comp = Comparator.comparing(Pair::getFreq);
        PriorityQueue<Pair> queue = new PriorityQueue<>(comp);

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            queue.add(new Pair(entry.getValue(), entry.getKey()));

            if(queue.size()>2 )
            {
                queue.poll();
            }
        }

        int[] output = new int[queue.size()];
        int i = queue.size();
        while(!queue.isEmpty())
        {
            --i;
            output[i] = queue.poll().val;
        }

        return output;
    }
}
