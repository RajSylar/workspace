package com.ip.sylar.tree.bst;

public class ValidateBTAsBST {
    Node root;

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

    private boolean isBinaryTreeABinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.data <= min || root.data > max)
            return false;

        return isBinaryTreeABinarySearchTree(root.left, min, root.data) &&
                isBinaryTreeABinarySearchTree(root.right, root.data, max);

    }

}
