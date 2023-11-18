package com.dsa.leetcode.labuladong.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @since 2023/11/18 12:46
 */
public class P46_Permutations {
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, 0);
        return ans;
    }

    private void backtrack(int[] nums, boolean[] used, int deep) {
        if (deep == nums.length) {
            ans.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backtrack(nums, used, deep + 1);
                path.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        P46_Permutations p46Permutations = new P46_Permutations();
        System.out.println(p46Permutations.permute(new int[]{1, 2, 3}));
    }
}
