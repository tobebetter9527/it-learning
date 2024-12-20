package com.dsa.leetcode.labuladong.graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @since 2024/7/3 21:20
 */
public class P323_NumberOfConnectedComponnentsInAnUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }
        return unionFind.size();
    }


    static class UnionFind {
        private int[] parent;
        private int[] sizes;
        private int count;

        public UnionFind(int count) {
            parent = new int[count];
            sizes = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
                sizes[i] = 1;
            }
            this.count = count;
        }

        public int find(int node) {
            Deque<Integer> stack = new LinkedList<>();
            while (node != parent[node]) {
                stack.add(node);
                node = parent[node];
            }
            while (!stack.isEmpty()) {
                parent[stack.pollLast()] = node;
            }
            return node;
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }
            if (sizes[rootA] > sizes[rootB]) {
                parent[rootB] = rootA;
                sizes[rootA] += sizes[rootB];
                sizes[rootB] = 0;
            } else {
                parent[rootA] = rootB;
                sizes[rootB] += sizes[rootA];
                sizes[rootA] = 0;
            }
            count--;
        }

        public int size() {
            return count;
        }
    }

    public static void main(String[] args) {
        // int n = 5;
        // int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        P323_NumberOfConnectedComponnentsInAnUndirectedGraph p323 = new P323_NumberOfConnectedComponnentsInAnUndirectedGraph();
        int i = p323.countComponents(n, edges);
        System.out.println(i);
    }
}
