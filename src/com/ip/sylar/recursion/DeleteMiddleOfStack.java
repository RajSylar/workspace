package com.ip.sylar.recursion;

import java.util.ListIterator;
import java.util.Stack;

public class DeleteMiddleOfStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        int mid = (stack.size() / 2) + 1;

        deleteMiddleElement(stack, mid);
        printStack(stack);
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

    private static void deleteMiddleElement(Stack<Integer> stack, int mid) {
        if (stack.isEmpty())
            return;

        if (mid == 1) {
            stack.pop();
            return;
        }

        int temp = stack.pop();
        deleteMiddleElement(stack, mid - 1);
        stack.push(temp);
        return;
    }
}
