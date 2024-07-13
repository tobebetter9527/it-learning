package com.dsa.leetcode.labuladong.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @since 2024/7/7 15:50
 */
public class P743_NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        // 邻接表，点到其所有边（边含有权重）
        List<int[]>[] graph = buildGraph(times, n);
        // 保存k点到目标点最短距离，初始默认最大
        int[] distMap = buildDIstMap(n);
        // k点到k点，距离当然为0
        distMap[k] = 0;
        // 加快速度，最有可能到达目标点
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        q.add(new int[]{k, 0});

        while (!q.isEmpty()) {
            int[] state = q.poll();
            int curNodeId = state[0];
            int distFromK = state[1];
            // 加快速度，因为可以从不同路径到达相同点
            if (distFromK > distMap[curNodeId]) {
                continue;
            }
            for (int[] edge : graph[curNodeId]) {
                int nextNodeId = edge[1];
                int w = edge[2];
                int distToNextNode = distMap[curNodeId] + w;
                if (distToNextNode < distMap[nextNodeId]) {
                    distMap[nextNodeId] = distToNextNode;
                    q.add(new int[]{nextNodeId, distToNextNode});
                }
            }
        }

        int max = distMap[1];
        for (int i = 2; i <= n; i++) {
            max = Math.max(max, distMap[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    private int[] buildDIstMap(int n) {
        int[] distMap = new int[n + 1];
        // fill the max value
        Arrays.fill(distMap, Integer.MAX_VALUE);
        return distMap;
    }

    /**
     * 邻接表，保存点到其所有边
     */
    private List<int[]>[] buildGraph(int[][] times, int n) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            int u = time[0];
            graph[u].add(time);
        }
        return graph;
    }

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        P743_NetworkDelayTime p743 = new P743_NetworkDelayTime();
        int i = p743.networkDelayTime(times, n, k);
        System.out.println(i);
    }
}
