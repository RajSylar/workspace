package com.ip.sylar.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {
    public static void main(String[] args) {
        String in = "aa";
        String op = "";
        Set<String> list = new HashSet<>();
        powerSet(in, op, list);
        System.out.println(list);
    }

    private static void powerSet(String in, String op, Set<String> list) {
        if (in.length() == 0) {
            list.add("'" + op + "'");
            return;
        }

        String op1 = op;

        String op2 = op.concat(in.substring(0, 1));

        powerSet(in.substring(1), op1, list);
        powerSet(in.substring(1), op2, list);
        return;
    }
}
