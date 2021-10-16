package com.ip.sylar.tree;

public class SameTree {
    public class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private boolean isSameTree(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 != null || root2 != null)
            return false;

        return root1.data == root2.data && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}
