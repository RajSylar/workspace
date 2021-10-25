package com.ip.sylar.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBalancedParentheses {
    public static void main(String[] args) {
        int n = 3;
        generateBalancedParentheses(n);
    }

    private static List<String> generateBalancedParentheses(int n) {

        int open = n;
        int close = n;
        String op = "";
        List<String> list = new ArrayList<>();

        generateParentheses(open, close, op, list);

        return list;
    }

    private static void generateParentheses(int open, int close, String op, List<String> list) {
        if (open == 0 && close == 0) {
            list.add(op);
            return;
        }

        if (open != 0) {
            String op1 = op.concat("(");
            generateParentheses(open - 1, close, op1, list);
        }

        if (close > open) {
            String op2 = op.concat(")");
            generateParentheses(open, close - 1, op2, list);
        }
        return;
    }
}
