package com.ip.sylar.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutation(s));
    }
    public static List<String> letterCasePermutation(String s) {

        List<String> list = new ArrayList<>();
        String op = "";

        fetchLetterCasePermutation(s, op, list);
        return list;
    }

    public static void fetchLetterCasePermutation(String ip, String op, List<String> list)
    {
        if(ip.length() == 0)
        {
            list.add(op);
            return;
        }

        if(isAlphabet(ip.charAt(0)))
        {
            fetchLetterCasePermutation(ip.substring(1), op.concat(ip.substring(0,1).toLowerCase()), list);
            fetchLetterCasePermutation(ip.substring(1), op.concat(ip.substring(0,1).toUpperCase()), list);
        }
        else
        {
            fetchLetterCasePermutation(ip.substring(1), op.concat(ip.substring(0,1)), list);
        }
        return;

    }

    public static boolean isAlphabet(char c)
    {
        return (c >='A' && c<'Z') || (c>='a' && c<'z');
    }
}
