package com.dsa.leetcode.labuladong.graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @since 2024/7/4 20:52
 */
public class P130_SurroundedRegions {

    public void solve(char[][] board) {
        int col = board[0].length;
        int row = board.length;

        UnionFind uf = new UnionFind(row * col + 1);
        int dummy = row * col;
        // first row and last row
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                uf.union(i, dummy);
            }
            if (board[row - 1][i] == 'O') {
                uf.union((row - 1) * col + i, dummy);
            }
        }

        // first col and last col
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                uf.union(i * col, dummy);
            }
            if (board[i][col - 1] == 'O') {
                uf.union((i + 1) * col - 1, dummy);
            }
        }
        int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == 'O') {
                            uf.union(x * col + y, i * col + j);
                        }
                    }
                }
            }
        }

        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (!uf.isConnected(i * col + j, dummy)) {
                    board[i][j] = 'X';
                }
            }
        }

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
}