package com.ip.sylar.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    class Duo
    {
        TreeNode node;
        int level;

        public Duo(TreeNode node, int level)
        {
            this.node = node;
            this.level = level;
        }

        public TreeNode getNode()
        {
            return this.node;
        }

        public int getLevel()
        {
            return this.level;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Queue<Duo> queue = new LinkedList<>();

        if(root == null)
            return list;

        int preLevel = -1;
        queue.add(new Duo(root, 0));

        while(!queue.isEmpty())
        {
            Duo duo = queue.poll();
            TreeNode temp = duo.getNode();
            int level = duo.getLevel();

            if(preLevel<duo.getLevel())
            {
                list.add(temp.val);
                preLevel++;
            }

            if(temp.right != null)
            {
                queue.add(new Duo(temp.right, level+1));
            }
            if(temp.left != null)
            {
                queue.add(new Duo(temp.left, level+1));
            }
        }
        return list;
    }
}
