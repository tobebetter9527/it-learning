package com.dsa.leetcode.labuladong.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @since 2024/6/9 19:11
 */
public class P797_AllPathsFromSourceToTarget {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> list = new LinkedList<>();
        traverse(graph, 0, list);
        return res;
    }

    public void traverse(int[][] graph, int rootIdx, LinkedList<Integer> list) {
        list.add(rootIdx);
        if (rootIdx == graph.length - 1) {
            res.add(new ArrayList<>(list));
            list.removeLast();
            return;
        }
        for (int i : graph[rootIdx]) {
            traverse(graph,i,list);
        }
        list.removeLast();
    }

}
