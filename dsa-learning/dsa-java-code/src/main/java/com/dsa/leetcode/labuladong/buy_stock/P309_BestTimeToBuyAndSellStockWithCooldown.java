package com.dsa.leetcode.labuladong.buy_stock;

public class P309_BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        return recursive(prices, 0, 0);
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

    public static void main(String[] args) {

    }
}
