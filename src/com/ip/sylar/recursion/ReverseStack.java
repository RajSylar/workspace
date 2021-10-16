package com.ip.sylar.recursion;

import java.util.ListIterator;
import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        printStack(stack);
        reverseStack(stack);
        System.out.println("   ");
        printStack(stack);
    }

    private static void reverseStack(Stack<Integer> stack) {

        if (stack.size() ==1)
            return;

        int temp = stack.pop();
        reverseStack(stack);
        insert(stack, temp);
        return;
    }

    private static void insert(Stack<Integer> stack, int temp) {
        if (stack.isEmpty()) {
            stack.push(temp);
            return;
        }
        int val = stack.pop();
        insert(stack, temp);
        stack.push(val);
        return;
    }

    static void printStack(Stack<Integer> s) {
        ListIterator<Integer> lt = s.listIterator();

        // forwarding
        while (lt.hasNext())
            lt.next();

        // printing from top to bottom
        while (lt.hasPrevious())
            System.out.print(lt.previous() + " ");
    }
}
