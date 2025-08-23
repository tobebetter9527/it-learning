package com.dsa.leetcode.labuladong2.binary.tree;

public class P538_ConvertBSTToGreaterTree {

    int sum;

    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.right);
        sum += root.val;
        root.val = sum;
        traversal(root.left);
    }
}
