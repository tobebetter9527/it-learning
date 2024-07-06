package com.dsa.leetcode.labuladong.graph;

import java.util.Arrays;

/**
 * @since 2024/7/6 14:29
 */
public class P1135_ConnectingCitiesWithMinimumCost {

    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (x, y) -> x[2] - y[2]);
        UnionFind uf = new UnionFind(n + 1);
        int sum = 0;

        for (int[] connection : connections) {
            int node1 = connection[0];
            int node2 = connection[1];
            int cost = connection[2];
            if (!uf.isConnected(node1, node2)) {
                uf.union(node1, node2);
                sum += cost;
            }
        }
        return (uf.size() - 1) == 1 ? sum : -1;
    }

    public static void main(String[] args) {
        //int n = 3;
        int n = 4;
        //int[][] connections = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
        int[][] connections = {{1,2,3}, {3,4,4}};
        P1135_ConnectingCitiesWithMinimumCost p1125 = new P1135_ConnectingCitiesWithMinimumCost();
        int i = p1125.minimumCost(n, connections);
        System.out.println(i);

    }

}
