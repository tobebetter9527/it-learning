package com.dsa.leetcode.labuladong2.backtracking;

import java.util.LinkedList;
import java.util.List;

public class P78_Subsets {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int i) {
        res.add(new LinkedList<>(track));
        for (int j = i; j < nums.length; j++) {
            track.add(nums[j]);
            backtrack(nums, j + 1);
            track.removeLast();
        }
    }
}
