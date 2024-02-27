package com.dsa.leetcode.labuladong.binary_tree;

public class P114_FlattenBinaryTreeToLinkedList {
    TreeNode pre;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
