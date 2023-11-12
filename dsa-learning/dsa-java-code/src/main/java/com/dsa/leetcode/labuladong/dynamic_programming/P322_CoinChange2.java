package com.dsa.leetcode.labuladong.dynamic_programming;

import java.util.Arrays;

/**
 * @since 2023/11/12 08:44
 */
public class P322_CoinChange2 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }

        return recursive(coins, amount);
    }

    private int recursive(int[] coins, int restAmount) {
        if (restAmount == 0) {
            return 0;
        }
        if (restAmount < 0) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int p = recursive(coins, restAmount - coin);
            if (p != -1) {
                min = Math.min(min, 1 + p);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int dp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int restAmount = 0; restAmount < dp.length; restAmount++) {
            for (int coin : coins) {
                if (restAmount >= coin) {
                    dp[restAmount] = Math.min(dp[restAmount], 1 + dp[restAmount - coin]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
