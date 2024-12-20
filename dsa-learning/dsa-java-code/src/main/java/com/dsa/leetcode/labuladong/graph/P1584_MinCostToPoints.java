package com.dsa.leetcode.labuladong.graph;

import java.util.Arrays;

/**
 * @since 2024/7/6 14:59
 */
public class P1584_MinCostToPoints {
    /**
     * kruskal
     *
     * @param points
     * @return
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] connections = new int[((n - 1) * n) / 2][3];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                connections[idx] = new int[3];
                connections[idx][0] = i;
                connections[idx][1] = j;
                connections[idx][2] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                idx++;
            }
        }

        Arrays.sort(connections, (x, y) -> x[2] - y[2]);
        int sum = 0;
        UnionFind uf = new UnionFind(n);
        for (int[] connection : connections) {
            int node1 = connection[0];
            int node2 = connection[1];
            int cost = connection[2];
            if (!uf.isConnected(node1, node2)) {
                uf.union(node1, node2);
                sum += cost;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        P1584_MinCostToPoints p1584 = new P1584_MinCostToPoints();
        int i = p1584.minCostConnectPoints(points);
        System.out.println(i);
    }
}
