package com.ip.sylar.tree.bst;

public class SearchInBST {

    class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private static Node search(Node root, int key) {
        if (root == null || key == root.data) {
            return root;
        } else if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    private static void searchIterative(Node root, int key) {

        if(root==null)
            System.out.println("not present");

        Node temp = root;

        while(temp !=null)
        {
            if(temp.data>key)
            {
                temp = temp.left;
            }
            else if(temp.data<key)
            {
                temp = temp.right;
            }
            else
            {
                System.out.println("present");
            }
        }
    }

}
