package com.ip.sylar.stack;

import java.util.*;

public class MaxAreaRectangle {
    static class Pair
    {
        private int ngv;
        private int idx;

        public Pair(int val, int index)
        {
            this.ngv = val;
            this.idx = index;
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[]{6, 2, 5, 4, 5, 1, 6};
        int n = arr.length;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();


        findNearestSmallerLeft(arr, n, left);

        findNearestSmallerRight(arr, n, right);


        Collections.reverse(right);
        int maxArea = 0;
        for(int i= 0; i<n; i++)
        {
            maxArea = Math.max(maxArea, arr[i]*(right.get(i)-left.get(i)-1));
        }

//        while(leftIterator.hasNext() && rightIterator.hasNext())
//        {
//            output.add(rightIterator.next() - leftIterator.next() -1);
//        }

        System.out.println(maxArea);

    }

    private static void findNearestSmallerRight(int[] arr, int n, List<Integer> right) {
        int preIdx = n;
        Stack<Pair> stack = new Stack<>();
        for(int i=n-1; i>=0; i--)
        {
            if(stack.empty())
            {
                right.add(preIdx);
            }
            else if(!stack.isEmpty() && arr[i]>stack.peek().ngv)
            {
                right.add(stack.peek().idx);
            }
            else if(!stack.isEmpty() && arr[i]<=stack.peek().ngv)
            {
                while(!stack.empty() && arr[i]<=stack.peek().ngv)
                {
                    stack.pop();
                }
                if(stack.empty())
                {
                    right.add(preIdx);
                }
                else if(arr[i]> stack.peek().ngv)
                {
                    right.add(stack.peek().idx);
                }
            }
            stack.push(new Pair(arr[i], i));
        }
    }

    private static void findNearestSmallerLeft(int[] arr, int n, List<Integer> left) {
        int preIdx = -1;
        Stack<Pair> stack = new Stack<>();
        for(int i=0; i<n; i++)
        {
            if(stack.isEmpty())
            {
                left.add(preIdx);
            }
            else if(!stack.isEmpty() && arr[i] > stack.peek().ngv)
            {
                left.add(stack.peek().idx);
            }
            else if(!stack.isEmpty() && arr[i] <= stack.peek().ngv)
            {
                while(!stack.empty() && arr[i] <= stack.peek().ngv)
                {
                    stack.pop();
                }
                if(stack.isEmpty())
                {
                    left.add(preIdx);
                }
                else if(arr[i] > stack.peek().ngv)
                {
                    left.add(stack.peek().idx);
                }
            }
            stack.push(new Pair(arr[i], i));
        }
    }
}
