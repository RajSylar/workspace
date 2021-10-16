package com.ip.sylar.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPostIn {

    static Map<Integer, Integer> map = new HashMap<>();
    static Node root;
    static int postIndex;
    static class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        int in[]   = {4, 8, 2, 5, 1, 6, 3, 7};
        int post[] = {8, 4, 5, 2, 6, 7, 3, 1};

        buildTree(in, post, in.length);
    }

    private static Node buildTree(int[] in, int[] post, int length) {
        for(int i=0; i<length; i++)
        {
            map.put(in[i], i);
        }
        postIndex = length-1;
        return buildTreeUtils(in, post, 0, length-1);
    }

    private static Node buildTreeUtils(int[] in, int[] post, int start, int end) {
        if(start> end)
            return null;

        int data = post[postIndex--];
        Node temp = new Node(data);

        if(start==end)
            return temp;

        int index = map.get(data);

        temp.right = buildTreeUtils(in, post, index+1, end);
        temp.left = buildTreeUtils(in, post, start, index-1);

        return temp;
    }
}
