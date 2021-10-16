package com.ip.sylar.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreIn {

    static Node root;
    static Map<Integer, Integer> map = new HashMap<>();
    static int preIndex = 0;

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Integer[] in = {4, 2, 1, 7, 5, 8, 3, 6};
        Integer[] pre = {1, 2, 4, 3, 5, 7, 8, 6};
        int len = in.length;
        root = buildTree(in, pre, len);
        printInorder(root);
    }

    private static Node buildTree(Integer[] in, Integer[] pre, int len) {

        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }

        return buildTreeUtils(in, pre, 0, len - 1);
    }

    static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }


    private static Node buildTreeUtils(Integer[] in, Integer[] pre, int start, int end) {

        if (start > end)
            return null;
        int data = pre[preIndex++];
        Node temp = new Node(data);
        if (start == end)
            return temp;
        int index = map.get(data);
        temp.left = buildTreeUtils(in, pre, start, index - 1);
        temp.right = buildTreeUtils(in, pre, index + 1, end);
        return temp;
    }
}
