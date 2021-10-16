package com.ip.sylar.tree;

public class SizeOfBinaryTree {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private int fetchSizeOfTree(Node root) {
        if (root == null)
            return 0;

        int leftSize = fetchSizeOfTree(root.left);
        int rightSize = fetchSizeOfTree(root.right);

        return leftSize + rightSize + 1;
    }

    private int heightOfBinaryTree(Node root) {
        if (root == null)
            return 0;

        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
