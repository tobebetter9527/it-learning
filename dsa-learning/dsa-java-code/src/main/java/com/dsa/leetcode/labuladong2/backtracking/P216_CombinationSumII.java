package com.dsa.leetcode.labuladong2.backtracking;

import java.util.LinkedList;
import java.util.List;

public class P216_CombinationSumII {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> track = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        backtrack(nums, 0, k, n);
        return res;
    }

    private void backtrack(int[] nums, int i, int k, int n) {
        if (k == 0 && sum == n) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (sum > n) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            track.add(nums[j]);
            sum += nums[j];
            backtrack(nums, j + 1, k - 1, n);
            track.removeLast();
            sum -= nums[j];
        }
    }
}
