package com.dsa.leetcode.labuladong.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @since 2024/6/28 22:31
 */
public class P207_CourseSchedule {
    boolean[] visited;
    boolean[] path;
    boolean hasCircle = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        path = new boolean[numCourses];

        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return hasCircle;
    }

    private void traverse(List<Integer>[] graph, int from) {
        if (path[from]) {
            hasCircle = false;
            return;
        }
        if (visited[from]) {
            return;
        }
        path[from] = true;
        visited[from] = true;
        for (Integer to : graph[from]) {
            traverse(graph, to);
        }
        path[from] = false;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int to = prerequisite[0];
            int from = prerequisite[1];
            graph[from].add(to);
        }
        return graph;
    }

    public static void main(String[] args) {
        int numCourse = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        P207_CourseSchedule p207 = new P207_CourseSchedule();
        boolean b = p207.canFinish(numCourse, prerequisites);
        System.out.println(b);

    }
}
