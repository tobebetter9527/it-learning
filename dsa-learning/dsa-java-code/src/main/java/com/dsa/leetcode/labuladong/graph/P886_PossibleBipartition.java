package com.dsa.leetcode.labuladong.graph;

import java.util.ArrayList;

/**
 * @since 2024/6/30 10:09
 */
public class P886_PossibleBipartition {
    boolean isBipartite = true;
    boolean[] colors;
    boolean[] visited;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        colors = new boolean[n + 1];
        visited = new boolean[n + 1];

        ArrayList<Integer>[] graph = build(n, dislikes);
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(graph, i);
            }
        }
        return isBipartite;
    }

    private void dfs(ArrayList<Integer>[] graph, int from) {
        if (!isBipartite) {
            return;
        }
        visited[from] = true;
        for (int to : graph[from]) {
            if (!visited[to]) {
                colors[to] = !colors[from];
                dfs(graph,to);
            } else {
                if (colors[to] == colors[from]) {
                    isBipartite = false;
                }
            }
        }
    }

    private ArrayList<Integer>[] build(int n, int[][] dislikes) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : dislikes) {
            int from = edge[0];
            int to = edge[1];
            // 无向图
            graph[from].add(to);
            graph[to].add(from);
        }
        return graph;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        P886_PossibleBipartition p886 = new P886_PossibleBipartition();
        boolean b = p886.possibleBipartition(n, dislikes);
        System.out.println(b);
    }
}
