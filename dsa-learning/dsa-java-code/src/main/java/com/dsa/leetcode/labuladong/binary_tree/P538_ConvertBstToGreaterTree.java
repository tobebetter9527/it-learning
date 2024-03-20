package com.dsa.leetcode.labuladong.binary_tree;

public class P538_ConvertBstToGreaterTree {
    int sum;

    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.right);
        sum += root.val;
        root.val = sum;
        inOrder(root.left);
    }
}
