package com.dsa.leetcode.labuladong2.backtracking;

import java.util.LinkedList;
import java.util.List;

public class P77_Combinations {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return res;
    }

    private void backtrack(int n, int k, int i) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int j = i; j <= n; j++) {
            track.add(j);
            backtrack(n, k, j + 1);
            track.removeLast();
        }
    }
}
