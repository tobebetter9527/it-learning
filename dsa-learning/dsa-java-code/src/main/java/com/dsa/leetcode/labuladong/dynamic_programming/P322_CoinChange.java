package com.dsa.leetcode.labuladong.dynamic_programming;

import java.util.Arrays;

/**
 * @since 2023/11/11 21:36
 */
public class P322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        return recursive(coins, 0, amount);
    }

    private int recursive(int[] coins, int idx, int restAmount) {
        if (restAmount == 0) {
            return 0;
        }
        if (idx == coins.length) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i * coins[idx] <= restAmount; i++) {
            int p = recursive(coins, idx + 1, restAmount - i * coins[idx]);
            if (p != -1) {
                res = Math.min(res, p + i);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dp1(int[] coins, int amount) {
        int m = coins.length + 1, n = amount + 1;
        int[][] dp = new int[m][n];
        for (int col = 0; col < n; col++) {
            dp[m - 1][col] = -1;
        }
        for (int row = 0; row < m; row++) {
            dp[row][0] = 0;
        }

        // 从下到上，从左到右
        for (int idx = m - 2; idx >= 0; idx--) {
            for (int restAmount = 1; restAmount <= amount; restAmount++) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i * coins[idx] <= restAmount; i++) {
                    int p = dp[idx + 1][restAmount - i * coins[idx]];
                    if (p != -1) {
                        min = Math.min(min, p + i);
                    }
                }
                dp[idx][restAmount] = min == Integer.MAX_VALUE ? -1 : min;
            }
        }

        return dp[0][amount];
    }

    private int dp2(int[] coins, int amount) {
        int m = coins.length + 1, n = amount + 1;
        int[][] dp = new int[m][n];
        for (int col = 0; col < n; col++) {
            dp[m - 1][col] = -1;
        }
        for (int row = 0; row < m; row++) {
            dp[row][0] = 0;
        }

        // 从下到上，从左到右
        for (int idx = m - 2; idx >= 0; idx--) {
            for (int restAmount = 1; restAmount <= amount; restAmount++) {
                int min = Integer.MAX_VALUE;
                if (dp[idx + 1][restAmount] != -1) {
                    min = Math.min(min, dp[idx + 1][restAmount]);
                }

                if (restAmount >= coins[idx]) {
                    if (dp[idx][restAmount - coins[idx]] != -1) {
                        min = Math.min(min, 1 + dp[idx][restAmount - coins[idx]]);
                    }
                }

                dp[idx][restAmount] = min == Integer.MAX_VALUE ? -1 : min;
            }
        }

        return dp[0][amount];
    }

    private int dp3(int[] coins, int amount) {
        int n = amount + 1;
        int[] dp = new int[n];
        for (int col = 0; col < n; col++) {
            dp[col] = -1;
        }
        dp[0] = 0;

        // 从下到上，从左到右
        for (int idx = coins.length - 1; idx >= 0; idx--) {
            for (int restAmount = coins[idx]; restAmount <= amount; restAmount++) {
                int min = Integer.MAX_VALUE;
                if (dp[restAmount] != -1) {
                    min = Math.min(min, dp[restAmount]);
                }

                if (dp[restAmount - coins[idx]] != -1) {
                    min = Math.min(min, 1 + dp[restAmount - coins[idx]]);
                }

                dp[restAmount] = min == Integer.MAX_VALUE ? -1 : min;
            }
        }

        return dp[amount];
    }

    private int dp4(int[] coins, int amount) {
        int n = amount + 1;
        int[] dp = new int[n];
        for (int col = 0; col < n; col++) {
            dp[col] = amount + 1;
        }
        dp[0] = 0;

        // 从下到上，从左到右
        for (int idx = coins.length - 1; idx >= 0; idx--) {
            for (int restAmount = coins[idx]; restAmount <= amount; restAmount++) {
                dp[restAmount] = Math.min(dp[restAmount], 1 + dp[restAmount - coins[idx]]);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[][] dp = new int[3][5];
        System.out.println(dp);
    }

}
