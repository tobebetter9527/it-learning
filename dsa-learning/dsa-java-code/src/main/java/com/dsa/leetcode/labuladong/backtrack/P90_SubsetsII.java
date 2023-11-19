package com.dsa.leetcode.labuladong.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @since 2023/11/19 08:41
 */
public class P90_SubsetsII {
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return ans;
    }

    private void backtrack(int[] nums, int start) {
        ans.add(new LinkedList<>(path));
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        P90_SubsetsII p90SubsetsII = new P90_SubsetsII();
        System.out.println(p90SubsetsII.subsetsWithDup(new int[]{1, 2, 2}));
    }

}
