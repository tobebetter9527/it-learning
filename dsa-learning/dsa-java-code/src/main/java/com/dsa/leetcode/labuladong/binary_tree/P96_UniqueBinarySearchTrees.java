package com.dsa.leetcode.labuladong.binary_tree;

public class P96_UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[][] nums = new int[n + 1][n + 1];
        return count(1, n, nums);
    }

    private int count(int left, int right, int[][] nums) {
        if (left >= right) {
            return 1;
        }
        if (nums[left][right] != 0) {
            return nums[left][right];
        }
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += count(left, i - 1, nums) * count(i + 1, right, nums);
        }
        nums[left][right] = res;
        return res;
    }
}
