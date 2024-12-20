package com.dsa.leetcode.labuladong.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @since 2024/6/29 20:33
 */
public class P210_CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        int[] inDegrees = buildInDegrees(numCourses, prerequisites);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int from = queue.poll();
            numCourses--;
            res[idx++] = from;
            for (Integer to : graph.get(from)) {
                if (--inDegrees[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        if (numCourses != 0) {
            return new int[0];
        }
        return res;
    }

    private int[] buildInDegrees(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        for (int[] edge : prerequisites) {
            inDegrees[edge[0]] += 1;
        }
        return inDegrees;
    }

    private List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int to = edge[0];
            int from = edge[1];
            graph.get(from).add(to);
        }
        return graph;
    }

    public static void main(String[] args) {
        int numCourse = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        P210_CourseScheduleII p207 = new P210_CourseScheduleII();
        int[] b = p207.findOrder(numCourse, prerequisites);
        for (int i : b) {
            System.out.println(i);
        }
        System.out.println(b);

    }
}
