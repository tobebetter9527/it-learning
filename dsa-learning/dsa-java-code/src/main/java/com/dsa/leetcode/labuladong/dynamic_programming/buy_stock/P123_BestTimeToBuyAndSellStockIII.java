package com.dsa.leetcode.labuladong.dynamic_programming.buy_stock;

/**
 * @since 2023/11/30 21:40
 */
public class P123_BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        P123_BestTimeToBuyAndSellStockIII p123 = new P123_BestTimeToBuyAndSellStockIII();
        System.out.println(p123.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        return dp1(prices, 4);
    }

    private int recursive(int[] prices, int idx, int doubleK, int status) {
        if (idx == prices.length) {
            return 0;
        }
        if (status == doubleK) {
            return 0;
        }
        // 可以买
        if ((status & 1) == 0) {
            // buy
            int p1 = -prices[idx] + recursive(prices, idx + 1, doubleK, status + 1);
            // not buy
            int p2 = recursive(prices, idx + 1, doubleK, status);
            return Math.max(p1, p2);
        } else {
            // can sell
            // sell
            int p1 = prices[idx] + recursive(prices, idx + 1, doubleK, status + 1);
            // not sell
            int p2 = recursive(prices, idx + 1, doubleK, status);
            return Math.max(p1, p2);
        }
    }

    private int dp1(int[] prices, int doubleK) {
        int m = prices.length + 1;
        int n = doubleK + 1;
        int[][] dp = new int[m][n];
        for (int row = 0; row < m; row++) {
            dp[row][doubleK] = 0;
        }
        for (int col = 0; col < n; col++) {
            dp[m - 1][0] = 0;
        }
        // 从下到上，从右到左
        for (int idx = m - 2; idx >= 0; idx--) {
            for (int status = n - 2; status >= 0; status--) {
                if ((status & 1) == 0) {
                    // buy
                    int p1 = -prices[idx] + dp[idx + 1][status + 1];
                    // not buy
                    int p2 = dp[idx + 1][status];
                    dp[idx][status] = Math.max(p1, p2);
                } else {
                    // can sell
                    // sell
                    int p1 = prices[idx] + dp[idx + 1][status + 1];
                    // not sell
                    int p2 = dp[idx + 1][status];
                    dp[idx][status] = Math.max(p1, p2);
                }
            }
        }
        return dp[0][0];
    }

}
