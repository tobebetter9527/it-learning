package com.dsa.leetcode.labuladong.array.prefix_sum;

public class P303_RangeSumQuery_Immutable {
    int[] sums;
    public P303_RangeSumQuery_Immutable(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}
