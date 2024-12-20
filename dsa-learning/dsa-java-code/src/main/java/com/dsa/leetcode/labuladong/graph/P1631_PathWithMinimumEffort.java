package com.dsa.leetcode.labuladong.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @since 2024/7/13 10:09
 */
public class P1631_PathWithMinimumEffort {

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        P1631_PathWithMinimumEffort p1631 = new P1631_PathWithMinimumEffort();
        int i = p1631.minimumEffortPath(heights);
        System.out.println(i);
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] distMap = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distMap[i], Integer.MAX_VALUE);
        }
        distMap[0][0] = 0;

        PriorityQueue<State> q = new PriorityQueue<>((a, b) -> a.w - b.w);
        q.add(new State(0, 0, 0));

        while (!q.isEmpty()) {
            State state = q.poll();
            int curX = state.x;
            int curY = state.y;
            int w = state.w;
            // 到达终点提前结束
            if (curX == m - 1 && curY == n - 1) {
                return w;
            }

            if (w > distMap[curX][curY]) {
                continue;
            }
            for (int[] neighbor : adjacent(m, n, curX, curY)) {
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                int nextW = Math.max(distMap[curX][curY], Math.abs(heights[curX][curY] - heights[nextX][nextY]));
                if (nextW < distMap[nextX][nextY]) {
                    distMap[nextX][nextY] = nextW;
                    q.add(new State(nextX, nextY, nextW));
                }
            }
        }

        return distMap[m - 1][n - 1];
    }

    public List<int[]> adjacent(int m, int n, int x, int y) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            int mx = x + dir[0];
            int ny = y + dir[1];
            if (mx >= 0 && mx < m && ny >= 0 && ny < n) {
                neighbors.add(new int[]{mx, ny});
            }
        }
        return neighbors;
    }


    static class State {
        int x, y;
        int w;

        public State(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
}
