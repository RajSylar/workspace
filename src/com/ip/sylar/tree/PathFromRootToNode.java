package com.ip.sylar.tree;

import java.util.*;

public class PathFromRootToNode {

    private TreeNode root;

    static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Stack<TreeNode> s1 = new Stack<>();

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);

        List<Integer> pathList = new ArrayList<>();
        findPathToNodeFromRoot(root, 1, pathList);
        int x = 5;

    }

    public static boolean findPathToNodeFromRoot(TreeNode root, int target, List<Integer> pathList) {
        if (root == null) {
            return false;
        }

        pathList.add(root.data);
        if (root.data == target) {
            return true;
        }

        if (findPathToNodeFromRoot(root.left, target, pathList) || findPathToNodeFromRoot(root.right, target, pathList)) {
            return true;
        }

        pathList.remove(pathList.size() - 1);
        return false;
    }
}
