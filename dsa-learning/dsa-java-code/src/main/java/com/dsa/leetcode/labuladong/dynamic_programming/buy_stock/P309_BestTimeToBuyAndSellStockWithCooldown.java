package com.dsa.leetcode.labuladong.dynamic_programming.buy_stock;

public class P309_BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        return dp(prices);
    }

    private int recursive(int[] prices, int i, int status) {
        if (i >= prices.length) {
            return 0;
        }
        // can buy
        if (status == 0) {
            // buy, you can't buy next day
            int p1 = -prices[i] + recursive(prices, i + 1, 1);
            // not buy
            int p2 = recursive(prices, i + 1, status);
            return Math.max(p1, p2);
        } else {
            // can sell
            int p1 = prices[i] + recursive(prices, i + 2, 0);
            // not sell
            int p2 = recursive(prices, i + 1, status);
            return Math.max(p1, p2);
        }
    }

    private int dp(int[] prices) {
        int n = prices.length + 2;
        int m = 2;
        int[][] dp = new int[n][m];
        for (int i = n - 3; i >= 0; i--) {
            for (int status = 0; status < m; status++) {
                // can buy
                if (status == 0) {
                    // buy, you can't buy next day
                    int p1 = -prices[i] + dp[i + 1][1];
                    // not buy
                    int p2 = dp[i + 1][status];
                    dp[i][status] = Math.max(p1, p2);
                } else {
                    // can sell
                    int p1 = prices[i] + dp[i + 2][0];
                    // not sell
                    int p2 = dp[i + 1][status];
                    dp[i][status] = Math.max(p1, p2);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        P309_BestTimeToBuyAndSellStockWithCooldown p309 = new P309_BestTimeToBuyAndSellStockWithCooldown();
        System.out.println(p309.maxProfit(prices));
    }
}
