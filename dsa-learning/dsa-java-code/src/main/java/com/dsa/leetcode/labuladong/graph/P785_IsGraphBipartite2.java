package com.dsa.leetcode.labuladong.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @since 2024/6/30 09:09
 */
public class P785_IsGraphBipartite2 {
    boolean isBipartite = true;
    boolean[] colors;
    boolean[] visited;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        colors = new boolean[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isBipartite || !visited[i]) {
                bfs(graph, i);
            }
        }
        return isBipartite;
    }

    private void bfs(int[][] graph, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()) {
            int from = queue.poll();
            visited[from] = true;
            for (int to : graph[from]) {
                if (!visited[to]) {
                    // change color
                    colors[to] = !colors[from];
                    queue.offer(to);
                } else {
                    // check "to" node's color
                    if (colors[to] == colors[from]) {
                        isBipartite = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        P785_IsGraphBipartite2 p785 = new P785_IsGraphBipartite2();
        boolean bipartite = p785.isBipartite(graph);
        System.out.println(bipartite);
    }

}
