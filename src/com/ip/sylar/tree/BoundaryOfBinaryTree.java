package com.ip.sylar.tree;

public class BoundaryOfBinaryTree {

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
        // construct a binary tree as per the above diagram
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.right = new Node(10);
        root.right.right.left = new Node(11);
        root.left.left.right.left = new Node(12);
        root.left.left.right.right = new Node(13);
        root.right.right.left.left = new Node(14);

        performBoundaryTraversal(root);
    }

    private static void performBoundaryTraversal(Node root) {

        if (root == null)
            return;

        System.out.println(root.data);

        printLeftBoundary(root.left);

        if (!(root.left == null && root.right == null)) {
            printLeaves(root);
        }

        printRightBoundary(root.right);
    }

    private static void printRightBoundary(Node root) {
        if (root == null)
            return;

        if (root.right != null) {
            printRightBoundary(root.right);
            System.out.println(root.data);
        } else if (root.left != null) {
            printRightBoundary(root.left);
            System.out.println(root.data);
        }
    }

    private static void printLeaves(Node root) {
        if(root == null)
            return;

        if (root.left != null) {
            printLeaves(root.left);
        }

        if (root.left == null && root.right == null) {
            System.out.println(root.data);
        }

        if (root.right != null) {
            printLeaves(root.right);
        }
    }

    private static void printLeftBoundary(Node root) {
        if (root == null)
            return;

        if (root.left != null) {
            System.out.println(root.data);
            printLeftBoundary(root.left);
        } else if (root.right != null) {
            System.out.println(root.data);
            printRightBoundary(root.right);
        }
    }
}
