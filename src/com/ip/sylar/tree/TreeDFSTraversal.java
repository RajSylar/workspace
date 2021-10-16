package com.ip.sylar.tree;

public class TreeDFSTraversal {

    Node root;

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

        public void left(int i) {
        }
    }

    private void preorder(Node node) {
        if (node == null)
            return;
        System.out.println(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    private void inorder(Node node) {
        if (node == null)
            return;
        preorder(node.left);
        System.out.println(node.data);
        preorder(node.right);
    }

    private void postorder(Node node) {
        if (node == null)
            return;
        preorder(node.left);
        preorder(node.right);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        TreeDFSTraversal treeDFSTraversal = new TreeDFSTraversal();
        treeDFSTraversal.root = new Node(1);
        treeDFSTraversal.root.left = new Node(2);
        treeDFSTraversal.root.right = new Node(3);
        treeDFSTraversal.root.left.left = new Node(4);
        treeDFSTraversal.root.left.right = new Node(5);


    }
}
