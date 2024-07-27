package com.dsa.leetcode.labuladong.math;

/**
 * @since 2024/7/25 21:32
 */
public class P268_MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0 ^ n;
        for (int i = 0; i < n; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }
}
