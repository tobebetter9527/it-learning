package com.dsa.leetcode.pingan;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P2093_MinimumCostToReachCityWithDiscounts {
    public static void main(String[] args) {
        // int n = 5;
        // int[][] highways = { { 0, 1, 4 }, { 2, 1, 3 }, { 1, 4, 11 }, { 3, 2, 3 }, { 3, 4, 2 } };
        // int discounts = 1;
        int n = 4;
        int[][] highways = { { 0,1,3 }, { 2,3,2 } };
        int discounts = 0;
        System.out.println(minimumCost(n, highways, discounts));
    }

    public static int minimumCost(int n, int[][] highways, int discounts) {
        List<int[]>[] nodes = new List[5];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int[] highway : highways) {
            int start = highway[0];
            int end = highway[1];
            int cost = highway[2];
            nodes[start].add(new int[] { end, cost });
            nodes[end].add(new int[]{start,cost});
        }

        int[][] dist = new int[n][discounts + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= discounts; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->x[0]- y[0]);
        pq.add(new int[]{0,0,0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cost = poll[0];
            int destination = poll[1];
            int usedDiscounts = poll[2];
            // 折扣用完了或者走重复的点
            if (usedDiscounts > discounts || dist[destination][usedDiscounts] < cost) {
                continue;
            }
            if (destination == n - 1) {
                return cost;
            }

            dist[destination][usedDiscounts] = cost;
            nodes[destination].forEach(x->{
                int nextDestination = x[0];
                int newCost = x[1];
                pq.add(new int[] { cost + newCost, nextDestination, usedDiscounts });
                pq.add(new int[] { cost + newCost / 2, nextDestination, usedDiscounts + 1 });
            });
        }
        return -1;
    }
}
