package com.ip.sylar.tree;

import java.util.List;

public class rootToLeafPathSum {
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

    private boolean findRootToLeafPath(Node root, int target, List<Integer> result) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            if (root.data == target) {
                result.add(root.data);
                return true;
            } else {
                return false;
            }
        }

        if (findRootToLeafPath(root.left, target - root.data, result)) {
            result.add(root.data);
            return true;
        }
        if (findRootToLeafPath(root.right, target - root.data, result)) {
            result.add(root.data);
            return true;
        }
        return false;
    }

    private int findMaxRootToLeafSum(Node root) {
        if (root == null)
            return 0;

        int left = findMaxRootToLeafSum(root.left);
        int right = findMaxRootToLeafSum(root.right);

        return (left > right ? left : right) + root.data;
    }

    public static void main(String[] args) {

    }
}
