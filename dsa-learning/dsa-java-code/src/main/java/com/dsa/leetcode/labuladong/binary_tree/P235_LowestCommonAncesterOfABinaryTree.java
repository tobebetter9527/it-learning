package com.dsa.leetcode.labuladong.binary_tree;

public class P235_LowestCommonAncesterOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int big = Math.max(p.val, q.val);
        int small = Math.min(p.val, q.val);
        return find(root, small, big);
    }

    private TreeNode find(TreeNode root, int small, int big) {
        if (root == null) {
            return null;
        }
        if (root.val < small) {
            return find(root.right, small, big);
        }
        if (root.val > big) {
            return find(root.left, small, big);
        }
        return root;
    }
}
