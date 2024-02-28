package com.dsa.leetcode.labuladong.binary_tree;

public class P654_MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxIndex = left;
        int maxValue = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (maxValue < nums[i]) {
                maxIndex = i;
                maxValue = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxValue);
        root.left = build(nums, left, maxIndex - 1);
        root.right = build(nums, maxIndex + 1, right);
        return root;
    }
}
