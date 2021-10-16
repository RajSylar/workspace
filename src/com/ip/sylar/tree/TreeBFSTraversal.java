package com.ip.sylar.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBFSTraversal {
    Node root;

    private static class Node {
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
        TreeBFSTraversal treeBFSTraversal = new TreeBFSTraversal();
        treeBFSTraversal.root = new Node(1);
        treeBFSTraversal.root.left = new Node(2);
        treeBFSTraversal.root.right = new Node(3);
        treeBFSTraversal.root.left.left = new Node(4);
        treeBFSTraversal.root.left.right = new Node(5);

        treeBFSTraversal(treeBFSTraversal.root);
    }

    private static void treeBFSTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        if (node == null)
            return;
        queue.add(node);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            System.out.println(temp.data);

            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }
}
