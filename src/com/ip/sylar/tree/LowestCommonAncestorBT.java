package com.ip.sylar.tree;

public class LowestCommonAncestorBT {
    Node root;

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

    public static void main(String[] args) {

    }

    public Node findLCA(Node root, Node n1, Node n2) {
        if (root == null) {
            return null;
        }

        if (root == n1 || root == n2) {
            return root;
        }

        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);

        if (left == null && right == null) {
            return null;
        }

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;

    }

}
