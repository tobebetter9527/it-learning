package com.dsa.leetcode.labuladong.graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @since 2024/7/6 14:34
 */
public class UnionFind {
    private int[] parent;
    private int count;
    Deque<Integer> stack = new LinkedList<>();

    public UnionFind(int count) {
        parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
        }
        this.count = count;
    }

    public int find(int node) {
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
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
        count--;
    }

    public int size() {
        return count;
    }
}
