package com.dsa.leetcode.labuladong.buy_stock;

/**
 * @since 2023/11/30 20:57
 */
public class P714_BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        return dp(prices, fee);
    }

    private int recursive(int[] prices, int i, int status, int fee) {
        if (i == prices.length) {
            return 0;
        }
        if (status == 0) {
            // buy
            int p1 = -prices[i] + recursive(prices, i + 1, 1, fee);
            // not buy
            int p2 = recursive(prices, i + 1, status, fee);
            return Math.max(p1, p2);
        } else {
            // sell
            int p1 = prices[i] - fee + recursive(prices, i + 1, 0, fee);
            // not sell
            int p2 = recursive(prices, i + 1, status, fee);
            return Math.max(p1, p2);
        }
    }

    private int dp(int[] prices, int fee) {
        int n = prices.length + 1;
        int m = 2;
        int[][] dp = new int[n][m];
        for (int i = n - 2; i >= 0; i--) {
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
                    int p1 = prices[i] - fee + dp[i + 1][0];
                    // not sell
                    int p2 = dp[i + 1][status];
                    dp[i][status] = Math.max(p1, p2);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        P714_BestTimeToBuyAndSellStockWithTransactionFee p714 = new P714_BestTimeToBuyAndSellStockWithTransactionFee();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(p714.maxProfit(prices, fee));
    }
}
