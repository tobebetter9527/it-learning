package com.dsa.leetcode.pingan;

import com.dsa.leetcode.labuladong.binary_tree.TreeNode;

public class P2773_HeightOfSpecialBinaryTree {
    int h = 0;
    public int heightOfTree(TreeNode root) {
        dfs(root, 0);
        return h;
    }
    private void dfs(TreeNode root, int i) {
        h = Math.max(h, i++);
        if (root.left != null && root.left.right != root) {
            dfs(root.left, i);
        }
        if (root.right != null && root.right.left != root) {
            dfs(root.right, i);
        }
    }
}
