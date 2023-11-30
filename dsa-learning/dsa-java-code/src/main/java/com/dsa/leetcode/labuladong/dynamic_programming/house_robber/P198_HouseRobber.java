package com.dsa.leetcode.labuladong.dynamic_programming.house_robber;

/**
 * @since 2023/11/30 22:16
 */
public class P198_HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return dp2(nums);
    }

    private int recursive(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        // rob
        int p1 = nums[i] + recursive(nums, i + 2);
        // not rob
        int p2 = recursive(nums, i + 1);
        return Math.max(p1, p2);
    }

    private int dp(int[] nums) {
        int n = nums.length + 2;
        int[] dp = new int[n];
        // 从右到左
        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }

    private int dp2(int[] nums) {
        int p = 0;
        int p1 = 0;
        int p2 = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            p = Math.max(nums[i] + p2, p1);
            p2 = p1;
            p1 = p;
        }
        return p;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        P198_HouseRobber p198 = new P198_HouseRobber();
        System.out.println(p198.rob(nums));
    }
}
