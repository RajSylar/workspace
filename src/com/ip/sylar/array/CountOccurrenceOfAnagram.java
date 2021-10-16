package com.ip.sylar.array;

import java.util.Arrays;

public class CountOccurrenceOfAnagram {
    public static void main(String args[]) {
        String string = "forxxorf";
        String word = "for";
        System.out.print(countAnagrams(string, word));
    }

    private static int countAnagrams(String string, String word) {
        int j = 0;
        char[] charArray = string.toCharArray();
        int len = charArray.length;
        int window = word.length();

        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for(int i=0; i<window; i++)
        {
            stringBuilder.append(charArray[i]);
        }
        if(isAnagram(stringBuilder, word))
            count++;

        for(int i=window; i<len; i++)
        {
            stringBuilder = new StringBuilder(stringBuilder.substring(1));
            stringBuilder.append(charArray[i]);
            if(isAnagram(stringBuilder, word))
                count++;
        }

        return count;
    }

    private static boolean isAnagram(StringBuilder stringBuilder, String word) {
        int[] count = new int[256];
        char[] host = stringBuilder.toString().toCharArray();
        char[] target = word.toCharArray();

        Arrays.sort(host);
        Arrays.sort(target);

        // Compare sorted strings
        for (int i = 0; i < host.length; i++)
            if (host[i] != target[i])
                return false;
        return true;
    }
}
