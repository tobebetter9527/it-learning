package com.dsa.leetcode.labuladong.math;

import java.util.*;

/**
 * @since 2024/7/27 16:53
 */
public class P398_RandomPickIndex {

    class Solution {
        Random random;
        Map<Integer, List<Integer>> map;

        public Solution(int[] nums) {
            random = new Random();
            map = new HashMap<>();
            for (int i = 0, len = nums.length; i < len; i++) {
                map.putIfAbsent(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> integers = map.get(target);
            return integers.get(random.nextInt(integers.size()));
        }
    }
}
