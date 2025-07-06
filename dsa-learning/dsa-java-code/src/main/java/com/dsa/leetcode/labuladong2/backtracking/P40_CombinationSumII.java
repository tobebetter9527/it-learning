package com.dsa.leetcode.labuladong2.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P40_CombinationSumII {

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> track = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }
    
    private void backtrack(int[] candidates, int i, int target) {
        if (target == 0) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (j > 0 && !used[j - 1] && candidates[j] == candidates[j - 1]) {
                continue;
            }
            track.add(candidates[j]);
            used[j] = true;
            target -= candidates[j];
            backtrack(candidates, j + 1, target);
            track.removeLast();
            target += candidates[j];
            used[j] = false;
        }
    }
}
