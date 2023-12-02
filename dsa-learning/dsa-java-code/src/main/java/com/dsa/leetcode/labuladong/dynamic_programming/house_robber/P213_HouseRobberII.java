package com.dsa.leetcode.labuladong.dynamic_programming.house_robber;

/**
 * @since 2023/11/30 22:16
 */
public class P213_HouseRobberII {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(dp2(nums, 0, nums.length - 2), dp2(nums, 1, nums.length - 1));
    }

    private int recursive(int[] nums, int start, int end) {
        if (start >= end + 1) {
            return 0;
        }
        // rob
        int p1 = nums[start] + recursive(nums, start + 2, end);
        // not rob
        int p2 = recursive(nums, start + 1, end);
        return Math.max(p1, p2);
    }

    private int dp(int[] nums, int start, int end) {
        int n = nums.length + 2;
        int[] dp = new int[n];
        // 从右到左
        for (int i = end; i >= start; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[start];
    }

    private int dp2(int[] nums, int start,int end) {
        int p = 0;
        int p1 = 0;
        int p2 = 0;
        for (int i = end; i >= start; i--) {
            p = Math.max(nums[i] + p2, p1);
            p2 = p1;
            p1 = p;
        }
        return p;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        P213_HouseRobberII p198 = new P213_HouseRobberII();
        System.out.println(p198.rob(nums));
    }
}
