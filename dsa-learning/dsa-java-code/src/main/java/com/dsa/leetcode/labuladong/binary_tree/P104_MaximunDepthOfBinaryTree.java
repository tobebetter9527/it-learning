package com.dsa.leetcode.labuladong.binary_tree;

public class P104_MaximunDepthOfBinaryTree {
    int maxDepth = 0;
    int depth = 0;

    /**
     * 遍历，回溯思想
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        traverse(root);
        return maxDepth;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        traverse(root.left);
        traverse(root.right);
        maxDepth = Math.max(maxDepth, depth);
        depth--;
    }

    /**
     * 分解问题思想
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth1 = maxDepth2(root.left);
        int depth2 = maxDepth2(root.right);
        return Math.max(depth2,depth1) + 1;
    }

}
