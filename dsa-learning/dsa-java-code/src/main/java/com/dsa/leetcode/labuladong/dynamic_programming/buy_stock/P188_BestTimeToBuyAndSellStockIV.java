package com.dsa.leetcode.labuladong.dynamic_programming.buy_stock;

public class P188_BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        return recursive(prices, 0, k * 2, 0);
    }

    /**
     * 递归
     *
     * @param prices  价格
     * @param idx     第几天
     * @param doubleK 总买卖次数
     * @param status  0可以买，1可以卖，2可以买，3可以卖，以此类推
     * @return max profit
     */
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

    private int dp2(int[] prices, int doubleK) {
        int m = prices.length + 1;
        int n = doubleK + 1;
        int[] dp = new int[n];

        // 从下到上，从左到右
        for (int idx = m - 2; idx >= 0; idx--) {
            for (int status = 0; status < doubleK; status++) {
                if ((status & 1) == 0) {
                    // buy
                    int p1 = -prices[idx] + dp[status + 1];
                    // not buy
                    int p2 = dp[status];
                    dp[status] = Math.max(p1, p2);
                } else {
                    // can sell
                    // sell
                    int p1 = prices[idx] + dp[status + 1];
                    // not sell
                    int p2 = dp[status];
                    dp[status] = Math.max(p1, p2);
                }
            }
        }
        return dp[0];
    }

    /**
     * 从dp1，画图推导
     *
     * @param prices
     * @param doubleK
     * @return
     */
    private int dp3(int[] prices, int doubleK) {
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
            for (int status = doubleK; status >= 2; status -= 2) {
                dp[idx][status - 1] = Math.max(dp[idx + 1][status - 1], dp[idx + 1][status] + prices[idx]);
                dp[idx][status - 2] = Math.max(dp[idx + 1][status - 2], dp[idx + 1][status - 1] - prices[idx]);
            }
        }
        return dp[0][0];
    }
}
