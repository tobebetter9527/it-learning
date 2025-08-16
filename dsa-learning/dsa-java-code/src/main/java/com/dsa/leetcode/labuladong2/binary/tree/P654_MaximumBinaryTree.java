package com.dsa.leetcode.labuladong2.binary.tree;

public class P654_MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = buildTree(nums, low, index - 1);
        root.right = buildTree(nums, index + 1, high);
        return root;
    }
}
