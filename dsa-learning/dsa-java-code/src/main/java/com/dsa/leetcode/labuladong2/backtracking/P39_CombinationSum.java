package com.dsa.leetcode.labuladong2.backtracking;

import java.util.LinkedList;
import java.util.List;

public class P39_CombinationSum {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> track = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int i, int target) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            track.add(candidates[j]);
            sum += candidates[j];
            backtrack(candidates, j, target);
            track.removeLast();
            sum -= candidates[j];
        }
    }
}
