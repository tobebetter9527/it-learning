package com.dsa.leetcode.pingan;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MinCostBond {
    public static void main(String[] args) {
        // int[] bonds = { 5, 100, 5, 100 };
        // System.out.println(minCost(bonds));
        // System.out.println(minCostPurchasingBonds(bonds));

        Random random = new Random();
        int n = 100;
        int len = 10;
        for (int i = 0; i < n; i++) {
            int[] bonds = new int[random.nextInt(1, len)];
            for (int j = 0; j < bonds.length; j++) {
                bonds[j] = random.nextInt(1, 100);
            }
            int cost1 = minCost(bonds);
            int cost2 = minCostPurchasingBonds(bonds);
            int cost3 = dp(bonds);
            if (cost1 != cost2 || cost3 != cost2) {
                System.out.println(cost1 + " - " + cost2 + " - " + cost3);
            }
        }
    }

    public static int minCost(int[] bonds) {
        return recursive(bonds, bonds.length);
    }

    private static int recursive(int[] bonds, int i) {
        if (i == 0) {
            return 0;
        }
        // 不利用免费
        int cost1 = bonds[i - 1] + recursive(bonds, i - 1);
        // 利用免费
        for (int j = 1; j <= i; j++) {
            if (j + j >= i) {
                int cost2 = recursive(bonds, j - 1) + bonds[j - 1];
                if (cost2 < cost1) {
                    cost1 = cost2;
                }
            }
        }
        return cost1;
    }

    private static int dp(int[] bonds) {
        int n = bonds.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = bonds[i - 1] + dp[i - 1];
            for (int j = 1; j <= i; j++) {
                if (j + j >= i) {
                    int cost2 = bonds[j - 1] + dp[j - 1];
                    dp[i] = Math.min(dp[i], cost2);
                }
            }
        }
        return dp[n];
    }



    // ------------------ //

    public static int minCostPurchasingBonds(int[] bondCost) {
        Map<String, Integer> map = new HashMap<>();
        return recursive(bondCost, 0, -1, map);
    }

    private static int recursive(int[] bondCost, int i, int j, Map<String, Integer> map) {
        if (i >= bondCost.length) {
            return 0;
        }
        String key = i + "-" + j;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int min = 0;
        if (j < i) {
            min = bondCost[i] + recursive(bondCost, i + 1, (i + 1) * 2 - 1, map);
        } else {
            int a = bondCost[i] + recursive(bondCost, i + 1, (i + 1) * 2 - 1, map);
            int b = recursive(bondCost, i + 1, j, map);
            min = Math.min(a, b);
        }
        map.put(key, min);
        return min;
    }
}
