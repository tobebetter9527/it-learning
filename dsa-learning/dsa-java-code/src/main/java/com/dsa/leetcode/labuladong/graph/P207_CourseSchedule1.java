package com.dsa.leetcode.labuladong.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @since 2024/6/28 22:31
 */
public class P207_CourseSchedule1 {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        int[] inDegrees = buildInDegrees(numCourses, prerequisites);

        // find courses with zero inDegree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer from = queue.poll();
            numCourses--;
            for (Integer to : graph.get(from)) {
                inDegrees[to] -= 1;
                if (inDegrees[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        return numCourses == 0;
    }

    private int[] buildInDegrees(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        for (int[] edge : prerequisites) {
            int to = edge[0];
            inDegrees[to] += 1;
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
        int numCourse = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        P207_CourseSchedule1 p207 = new P207_CourseSchedule1();
        boolean b = p207.canFinish(numCourse, prerequisites);
        System.out.println(b);

    }
}
