package com.ip.sylar.recursion;

import java.util.ListIterator;
import java.util.Stack;

public class StackSorting {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(0);
        stack.push(10);
        sortStack(stack);
        printStack(stack);
    }

    public static void sortStack(Stack<Integer> s) {
        if (s.size() == 1)
            return;

        int temp = s.pop();
        sortStack(s);

        insert(s, temp);

    }

    private static void insert(Stack<Integer> s, int temp) {
        if (s.size() == 0 || s.peek() <= temp) {
            s.push(temp);
            return;
        }

        int val = s.pop();
        insert(s, temp);
        s.push(val);
    }

    static void printStack(Stack<Integer> s)
    {
        ListIterator<Integer> lt = s.listIterator();

        // forwarding
        while (lt.hasNext())
            lt.next();

        // printing from top to bottom
        while (lt.hasPrevious())
            System.out.print(lt.previous() + " ");
    }
}
