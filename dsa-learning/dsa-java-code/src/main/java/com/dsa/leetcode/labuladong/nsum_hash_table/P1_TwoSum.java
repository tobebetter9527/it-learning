package com.dsa.leetcode.labuladong.nsum_hash_table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @since 2023/12/2 12:09
 */
public class P1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        P1_TwoSum p1 = new P1_TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Arrays.stream(p1.twoSum(nums, target)).forEach(System.out::println);
    }

}
