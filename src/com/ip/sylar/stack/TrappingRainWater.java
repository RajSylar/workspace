package com.ip.sylar.stack;

import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = new int[]{1,3,0,0,2,0,4};

        System.out.println(maxWater(height));
    }

    public static int trap(int[] height) {
        int n = height.length;

        int[] right = new int[n];

        right[n - 1] = height[n - 1];
        int max = right[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (max < height[i]) {
                max = height[i];
            }
            right[i] = max;
        }

        int total = 0;

        int leftMax = height[0];

        for (int i = 1; i < n - 1; i++) {
            leftMax = Math.max(leftMax, height[i]);

            total = total + (Math.min(leftMax, right[i]) - height[i]);
        }
        return total;
    }

    public static int maxWater(int[] height) {
        // Stores the indices of the bars
        Stack<Integer> stack = new Stack<>();

        // size of the array
        int n = height.length;

        // Stores the final result
        int ans = 0;

        // Loop through the each bar
        for (int i = 0; i < n; i++) {

            // Remove bars from the stack
            // until the condition holds
            while ((!stack.isEmpty())
                    && (height[stack.peek()] < height[i])) {

                // store the height of the top
                // and pop it.
                int pop_height = height[stack.peek()];
                stack.pop();

                // If the stack does not have any
                // bars or the the popped bar
                // has no left boundary
                if (stack.isEmpty())
                    break;

                // Get the distance between the
                // left and right boundary of
                // popped bar
                int distance = i - stack.peek() - 1;

                // Calculate the min. height
                int min_height
                        = Math.min(height[stack.peek()],
                        height[i])
                        - pop_height;

                ans += distance * min_height;
            }

            // If the stack is either empty or
            // height of the current bar is less than
            // or equal to the top bar of stack
            stack.push(i);
        }

        return ans;
    }
}
