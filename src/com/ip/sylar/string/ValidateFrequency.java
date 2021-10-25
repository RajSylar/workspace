package com.ip.sylar.string;

import java.util.HashMap;
import java.util.Map;

public class ValidateFrequency {

    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String s = "xxyyaaaa";

        char[] c = s.toCharArray();
        intialize(c);
        System.out.println(validateWithOneRemoval(map));
    }

    private static void intialize(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
    }

    public static boolean validateStringForFrequency(Map<Character, Integer> map) {
        int count = 0;
        int finalCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            count = entry.getValue();
            if (finalCount == 0 && count > 0) {
                finalCount = count;
            }

            if (count > 0 && count != finalCount) {
                return false;
            }

        }
        return true;
    }

    public static boolean validateWithOneRemoval(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();

            int count = entry.getValue();

            map.put(key, count - 1);

            boolean op = validateStringForFrequency(map);

            map.put(key, count);

            if (op == true) {
                return true;
            }
        }

        return false;
    }
}
