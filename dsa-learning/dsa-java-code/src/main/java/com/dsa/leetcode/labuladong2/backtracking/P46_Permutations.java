package com.dsa.leetcode.labuladong2.backtracking;

import java.util.LinkedList;
import java.util.List;

public class P46_Permutations {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> track = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                track.add(nums[i]);
                used[i] = true;
                backtrack(nums);
                track.removeLast();
                used[i] = false;
            }
        }
    }
}
