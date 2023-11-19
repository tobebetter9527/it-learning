package com.dsa.leetcode.labuladong.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @since 2023/11/19 15:15
 */
public class P39_CombinationSum {
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return ans;
    }

    private void backtrack(int[] candidates, int restTarget, int start) {
        if (restTarget == 0) {
            ans.add(new LinkedList<>(path));
            return;
        }
        if (restTarget < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(candidates, restTarget - candidates[i], i);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        P39_CombinationSum p39CombinationSum = new P39_CombinationSum();
        System.out.println(p39CombinationSum.combinationSum(candidates, target));

    }
}
