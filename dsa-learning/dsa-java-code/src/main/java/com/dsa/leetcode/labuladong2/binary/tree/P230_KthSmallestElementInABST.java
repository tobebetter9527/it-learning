package com.dsa.leetcode.labuladong2.binary.tree;

public class P230_KthSmallestElementInABST {
    int res;
    int rank;

    public int kthSmallest(TreeNode root, int k) {
        traversal(root, k);
        return res;
    }

    private void traversal(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traversal(root.left, k);
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        traversal(root.right, k);
    }
}
