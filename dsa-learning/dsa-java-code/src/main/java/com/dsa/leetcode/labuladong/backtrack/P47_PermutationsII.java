package com.dsa.leetcode.labuladong.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @since 2023/11/19 13:38
 */
public class P47_PermutationsII {
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used);
        return ans;
    }

    private void backtrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            ans.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && !used[i - 1] && nums[i - 1] == nums[i])) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        P47_PermutationsII p46Permutations = new P47_PermutationsII();
        System.out.println(p46Permutations.permuteUnique(nums));
    }
}
