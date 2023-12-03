package com.dsa.leetcode.labuladong.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @since 2023/12/3 12:17
 */
public class P15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        int end = nums.length - 2;
        for (int i = 0; i < end; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    while (j < k && nums[k] == nums[--k]) ;
                } else if (sum < 0) {
                    while (j < k && nums[j] == nums[++j]) ;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[k] == nums[--k]) ;
                    while (j < k && nums[j] == nums[++j]) ;
                }
            }
        }
        return ans;
    }

    /**
     * 先考察两数之和，结果不能重复
     * 先排序，再用双指针技巧
     *
     * @param nums   sorted array
     * @param target 目标值
     * @param start  开始索引
     * @return
     */
    public List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        int low = start, high = nums.length - 1;
        while (low < high) {
            int left = nums[low], right = nums[high];
            int sum = left + right;
            if (sum > target) {
                while (low < high && nums[high] == right) {
                    high--;
                }
            } else if (sum < target) {
                while (low < high && nums[low] == left) {
                    low++;
                }
            } else {
                ans.add(new ArrayList<>(Arrays.asList(left, right)));
                while (low < high && nums[low] == left) {
                    low++;
                }
                while (low < high && nums[high] == right) {
                    high--;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSumTarget(int[] nums, int start, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        int end = nums.length - 2;
        for (int i = start; i < end; i++) {
            while (i > 0 && nums[i] == nums[i - 1]) {
                i++;
            }
            List<List<Integer>> lists = twoSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> list : lists) {
                list.add(nums[i]);
                ans.add(list);
            }
            // 跳过重复的,这种写法也可以
//            while (i < end && nums[i] == nums[i + 1]) {
//                i++;
//            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P15_3Sum p15 = new P15_3Sum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        Arrays.sort(nums);
        System.out.println(p15.threeSum(nums));
    }
}


