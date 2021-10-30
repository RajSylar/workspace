package com.ip.sylar.string;

public class WordFormation {

    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
    }

    public static int countCharacters(String[] words, String chars) {
        char[] map = new char[26];

        for (int i = 0; i < chars.length(); i++) {
            map[chars.charAt(i) - 'a']++;
        }

        int length = 0;

        for (String word : words) {
            boolean flag = true;
            char[] freq = new char[26];
            for (int i = 0; i < word.length(); i++) {
                char cur = freq[word.charAt(i) - 'a'];
                cur++;

                if (freq[cur] > map[cur]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                length = length + word.length();
            }
        }

        return length;
    }
}
