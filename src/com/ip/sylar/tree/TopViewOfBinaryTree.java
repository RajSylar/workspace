package com.ip.sylar.tree;

import java.util.Map;
import java.util.TreeMap;

public class TopViewOfBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair {
        int val;
        int level;

        private Pair(int first, int second) {
            this.val = first;
            this.level = second;
        }
    }

    public static void main(String[] args) {
        // construct a binary tree as per the above diagram
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        topViewOfTree(root);
    }

    private static void topViewOfTree(Node root) {
        if (root == null)
            return;

        Map<Integer, Pair> map = new TreeMap<>();

        printTopView(root, 0, 0, map);

        for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
            System.out.println(entry.getValue().val);
        }
    }

    private static void printTopView(Node root, int hd, int level, Map<Integer, Pair> map) {

        if (root == null)
            return;

        if (!map.containsKey(hd)) {
            map.put(hd, new Pair(root.data, level));
        } else if (level < map.get(hd).level) {
            map.put(hd, new Pair(root.data, level));
        }

        printTopView(root.left, hd - 1, level + 1, map);
        printTopView(root.right, hd + 1, level + 1, map);
    }

}
