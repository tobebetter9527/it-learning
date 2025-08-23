package com.dsa.leetcode.labuladong2.binary.tree;

public class P701_InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            pre = cur;
            if (val > cur.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        if (val > pre.val) {
            pre.right = new TreeNode(val);
        } else {
            pre.left = new TreeNode(val);
        }
        return root;
    }
}
