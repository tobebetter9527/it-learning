package com.dsa.leetcode.labuladong.binary_tree;

public class P230_KthSmallestElementInBST {
    int res;
    int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root.val;
        }
        inOrder(root.right);
    }
}
