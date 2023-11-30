package com.dsa.leetcode.labuladong.buy_stock;

public class P122_BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        return dp(prices);
    }

    private int recursive(int[] prices, int i, int status) {
        if (i == prices.length) {
            return 0;
        }
        // can buy
        if (status == 0) {
            // buy
            int p1 = -prices[i] + recursive(prices, i + 1, 1);
            // not buy
            int p2 = recursive(prices, i + 1, status);
            return Math.max(p1, p2);
        } else {
            // can sell
            int p1 = prices[i] + recursive(prices, i + 1, 0);
            // not sell
            int p2 = recursive(prices, i + 1, status);
            return Math.max(p1, p2);
        }
    }

    private int dp(int[] prices) {
        int n = prices.length + 1;
        int m = 2;
        int[][] dp = new int[n][m];
        // 这个可以省
        for (int i = 0; i < m; i++) {
            dp[n - 1][i] = 0;
        }

        // 从下到上，从左到右
        for (int i = n - 2; i >= 0; i--) {
            for (int status = 0; status < m; status++) {
                if (status == 0) {
                    // buy
                    int p1 = -prices[i] + dp[i + 1][1];
                    // not buy
                    int p2 = dp[i + 1][status];
                    dp[i][status] = Math.max(p1, p2);
                } else {
                    // can sell
                    int p1 = prices[i] + dp[i + 1][0];
                    // not sell
                    int p2 = dp[i + 1][status];
                    dp[i][status] = Math.max(p1, p2);
                }
            }
        }
        return dp[0][0];
    }

    private int greedy(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(prices[i] - prices[i - 1], 0);
        }
        return profit;
    }

}
