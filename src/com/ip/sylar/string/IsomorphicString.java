package com.ip.sylar.string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "title"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s_chars = s.charAt(i);
            char t_chars = t.charAt(i);
            if (!map.containsKey(s_chars)) {
                if (map.containsValue(t_chars)) {
                    return false;
                }
                map.put(s_chars, t_chars);
            } else if (map.get(s_chars) != t_chars) {
                return false;
            }
        }
        return true;
    }
}
