package com.ip.sylar.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveVowels {

    public static void main(String[] args) {
        String string = new String("Chennai Express");
        System.out.println(removeVowel(string));
    }

    private static StringBuilder removeVowel(String string) {
        Character[] vowels = new Character[]{'a','e','i','o','u','A','E','I','O','U'};
        List<Character> vowelList = Arrays.asList(vowels);
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : string.toCharArray())
        {
            if(!vowelList.contains(c))
            {
                stringBuilder.append(c);
            }
        }
        return stringBuilder;
    }
}
