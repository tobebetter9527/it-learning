package com.dsa.leetcode.labuladong.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @since 2023/11/18 10:41
 */
public class P78_Subsets {
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }

    private void backtrack(int[] nums, int start) {
        // 前序收集
        ans.add(new LinkedList<>(path));
        // 终止条件可以不写
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        P78_Subsets subsets = new P78_Subsets();
        System.out.println(subsets.subsets(nums));
    }

}
