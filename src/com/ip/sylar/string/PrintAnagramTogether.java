package com.ip.sylar.string;

import java.util.*;

public class PrintAnagramTogether {

    static HashMap<String, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        String[] string = new String[]{"cat", "dog", "tac", "god", "act"};
        printAnagramTogether(string);
    }

    private static void printAnagramTogether(String[] string) {
        for (String word : string) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            if (map.containsKey(sortedWord)) {
                map.get(sortedWord).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(sortedWord, list);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
