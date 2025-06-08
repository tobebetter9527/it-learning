package com.dsa.leetcode.labuladong2.binary.tree;

public class P543_DiameterOfBinaryTree {
    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return res;
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}
