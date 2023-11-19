package com.dsa.leetcode.labuladong.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @since 2023/11/19 10:42
 */
public class P40_CombinationSumII {
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int pathSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return ans;
    }

    private void backtrack(int[] candidates, int target, int start) {
        if (pathSum == target) {
            ans.add(new LinkedList<>(path));
            return;
        }
        if (pathSum > target || start == candidates.length) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i - 1] == candidates[i]) {
                continue;
            }
            pathSum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, target, i + 1);
            path.removeLast();
            pathSum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        P40_CombinationSumII p40CombinationSumII = new P40_CombinationSumII();
        System.out.println(p40CombinationSumII.combinationSum2(candidates, target));
    }
}
