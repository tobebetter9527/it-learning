package com.dsa.leetcode.labuladong.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @since 2024/7/13 15:46
 */
public class P1514_PathWithMaximumProbability {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<double[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0, len = succProb.length; i < len; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];
            double prob = succProb[i];
            graph[from].add(new double[]{to, prob});
            graph[to].add(new double[]{from, prob});
        }

        double[] distMap = new double[n];
        Arrays.fill(distMap, -1);
        distMap[start_node] = 1;

        PriorityQueue<State> q = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        q.add(new State(start_node, 1));

        while (!q.isEmpty()) {
            State state = q.poll();
            int curId = state.id;
            double prob = state.prob;
            if (curId == end_node) {
                return prob;
            }
            if (prob < distMap[curId]) {
                continue;
            }
            for (double[] doubles : graph[curId]) {
                int nextId = (int) doubles[0];
                double nextPro = doubles[1];
                nextPro = nextPro * distMap[curId];
                if (nextPro > distMap[nextId]) {
                    distMap[nextId] = nextPro;
                    q.add(new State(nextId, nextPro));
                }
            }
        }
        return 0;
    }

    static class State {
        int id;
        double prob;

        public State(int id, double prob) {
            this.id = id;
            this.prob = prob;
        }
    }


}
