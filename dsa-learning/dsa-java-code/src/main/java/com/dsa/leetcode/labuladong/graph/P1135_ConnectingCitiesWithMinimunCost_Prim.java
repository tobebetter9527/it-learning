package com.dsa.leetcode.labuladong.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @since 2024/7/7 10:17
 */
public class P1135_ConnectingCitiesWithMinimunCost_Prim {

    /**
     * kruskal
     *
     * @param n
     * @param connections
     * @return
     */
    public int minimumCost(int n, int[][] connections) {
        List<int[]>[] graph = buildGraph(n, connections);
        Prim prim = new Prim(graph);
        return prim.getWeightSum();
    }

    private List<int[]>[] buildGraph(int n, int[][] connections) {
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] connection : connections) {
            int from = connection[0] - 1;
            int to = connection[1] - 1;
            int cost = connection[2];
            graph[from].add(new int[]{from, to, cost});
            graph[to].add(new int[]{to, from, cost});
        }
        return graph;
    }

    public static void main(String[] args) {
        // int n = 3;
        int n = 4;
        //int[][] connections = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
        int[][] connections = {{1, 2, 3}, {3, 4, 4}};
        P1135_ConnectingCitiesWithMinimunCost_Prim p1125 = new P1135_ConnectingCitiesWithMinimunCost_Prim();
        int i = p1125.minimumCost(n, connections);
        System.out.println(i);

    }


    static class Prim {
        // 邻接表，索引表示node，List<int[]>表示edge, edge[0]-from,edge[1]-to,edge[2]-cost
        private List<int[]>[] graph;
        private int weightSum;
        private PriorityQueue<int[]> heap;
        private boolean[] visited;
        private int n;

        public Prim(List<int[]>[] graph) {
            this.graph = graph;
            n = graph.length;
            visited = new boolean[n];
            heap = new PriorityQueue<>((x, y) -> x[2] - y[2]);

            // it is ok starting from any node, so, just from 0 node
            visited[0] = true;
            cutNode(0);

            // bfs
            while (!heap.isEmpty()) {
                int[] edge = heap.poll();
                int to = edge[1];
                if (!visited[to]) {
                    weightSum += edge[2];
                    visited[to] = true;
                    cutNode(to);
                }
            }
        }

        private void cutNode(int node) {
            for (int[] edge : graph[node]) {
                int to = edge[1];
                // 不加这个，循环不停止
                if (!visited[to]) {
                    heap.add(edge);
                }
            }
        }

        public int getWeightSum() {
            return isAllConnected() ? weightSum : -1;
        }

        public boolean isAllConnected() {
            for (boolean b : visited) {
                if (!b) {
                    return false;
                }
            }
            return true;
        }
    }
}
