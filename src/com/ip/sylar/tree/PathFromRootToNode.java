package com.ip.sylar.tree;

import java.util.*;

public class PathFromRootToNode {

    private TreeNode root;

    class TreeNode {
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

    }

    public boolean findPathToNodeFromRoot(TreeNode root, TreeNode target, List<Integer> pathList) {
        if (root == null) {
            return false;
        }

        pathList.add(root.data);
        if (root.data == target.data) {
            return true;
        }

        if (findPathToNodeFromRoot(root.left, target, pathList) || findPathToNodeFromRoot(root.right, target, pathList))
        {
            return true;
        }

        pathList.remove(pathList.size() - 1);
        return false;
    }
}
