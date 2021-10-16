package com.ip.sylar.string;

import java.util.ArrayList;
import java.util.List;

public class MissingInPangram {

    static ArrayList<Character> output = new ArrayList<>();

    static boolean[] flagged = new boolean[26];

    public static void main(String[] args) {
        String input = "a";

        List<Character> charOutput = fetchMissingPangram(input);
        System.out.println(charOutput);
    }

    private static ArrayList<Character> fetchMissingPangram(String input) {
        for (int i = 0; i < input.length(); i++) {
            if ('A' <= input.charAt(i) && input.charAt(i) <= 'Z') {
                flagged[input.charAt(i) - 'A'] = true;
            } else if ('a' <= input.charAt(i) && input.charAt(i) <= 'z') {
                flagged[input.charAt(i) - 'a'] = true;
            }
        }

        for (int i = 0; i < flagged.length; i++) {
            if (flagged[i] == false)
                output.add((char) ('A' + i));
        }
        return output;
    }
}
