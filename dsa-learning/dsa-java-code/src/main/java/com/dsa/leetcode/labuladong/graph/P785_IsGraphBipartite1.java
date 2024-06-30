package com.dsa.leetcode.labuladong.graph;

/**
 * @since 2024/6/30 09:09
 */
public class P785_IsGraphBipartite1 {
    boolean isBipartite = true;
    boolean[] colors;
    boolean[] visited;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        colors = new boolean[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i);
            }
        }
        return isBipartite;
    }

    private void dfs(int[][] graph, int i) {
        if (!isBipartite) {
            return;
        }
        visited[i] = true;
        for (int to : graph[i]) {
            if (!visited[to]) {
                // change color
                colors[to] = !colors[i];
                dfs(graph, to);
            } else {
                // check "to" node's color
                if (colors[to] == colors[i]) {
                    isBipartite = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        P785_IsGraphBipartite1 p785 = new P785_IsGraphBipartite1();
        boolean bipartite = p785.isBipartite(graph);
        System.out.println(bipartite);
    }

}
