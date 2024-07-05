package com.dsa.leetcode.labuladong.graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @since 2024/7/5 21:57
 */
public class P990_SatisfiabilityOfEqualityEquations {

    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                uf.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (uf.isConnected(equation.charAt(0) - 'a', equation.charAt(3) - 'a')) {
                    return false;
                }
            }
        }

        return true;
    }

    static class UnionFind {
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

    public static void main(String[] args) {
        // String[] equations = {"a==b", "b!=a"};
        String[] equations = {"a==b", "b==a"};
        P990_SatisfiabilityOfEqualityEquations p990 = new P990_SatisfiabilityOfEqualityEquations();
        boolean b = p990.equationsPossible(equations);
        System.out.println(b);

    }
}
