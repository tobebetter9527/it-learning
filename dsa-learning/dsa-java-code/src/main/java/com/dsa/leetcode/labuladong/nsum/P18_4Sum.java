package com.dsa.leetcode.labuladong.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @since 2023/12/3 16:58
 */
public class P18_4Sum {

    public static void main(String[] args) {
        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        int target = -11;
        Arrays.sort(nums);
        P18_4Sum p18 = new P18_4Sum();
        System.out.println(p18.fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int end1 = nums.length - 3;
        int end2 = nums.length - 2;
        List<List<Integer>> ans = new ArrayList<>();
        long lastThreeSum = (long) nums[end1] + nums[end2] + nums[end2 + 1];
        long lastTwoSum = (long) nums[end1 + 1] + nums[end2 + 1];
        for (int a = 0; a < end1; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            if ((long) nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) {
                break;
            }
            if ((long) nums[a] + lastThreeSum < target) {
                continue;
            }
            for (int b =  a + 1; b < end2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                if ((long) nums[a] + nums[b] + nums[b + 1] + nums[b + 2] > target) {
                    break;
                }
                if ((long) nums[a] + nums[b] + lastTwoSum < target) {
                    continue;
                }
                int left = b + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[a] + nums[b] + nums[left] + nums[right];
                    if (sum > target) {
                        while (left < right && nums[right] == nums[--right]);
                    } else if (sum < target) {
                        while (left < right && nums[left] == nums[++left]);
                    } else {
                        ans.add(Arrays.asList(nums[a], nums[b], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[--right]);
                        while (left < right && nums[left] == nums[++left]);
                    }
                }
            }
        }
        return ans;
    }


    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        return nSumTarget(nums, 0, target, 4);
    }

    public List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = start, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                while (left < right && nums[right] == nums[--right]) ;
            } else if (sum < target) {
                while (left < right && nums[left] == nums[++left]) ;
            } else {
                ans.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
                while (left < right && nums[right] == nums[--right]) ;
                while (left < right && nums[left] == nums[++left]) ;
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSumTarget(int[] nums, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int end = nums.length - 2;
        for (int i = start; i < end; i++) {
            // 排除重复的
            while (i > start && i < end && nums[i] == nums[i - 1]) {
                i++;
            }

            List<List<Integer>> lists = twoSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> list : lists) {
                list.add(nums[i]);
                ans.add(list);
            }
        }
        return ans;
    }

    public List<List<Integer>> fourSumTarget(int[] nums, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int end = nums.length - 3;
        for (int i = start; i < end; i++) {
            while (i > start && i < end && nums[i] == nums[i - 1]) {
                i++;
            }
            List<List<Integer>> lists = threeSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> list : lists) {
                list.add(nums[i]);
                ans.add(list);
            }
        }
        return ans;
    }

    /**
     * 通用的n sum问题
     * 边界问题不好处理
     *
     * @param nums
     * @param start
     * @param target
     * @param nSum
     * @return
     */
    public List<List<Integer>> nSumTarget(int[] nums, int start, int target, int nSum) {
        if (nSum == 2) {
            return twoSumTarget(nums, start, target);
        } else {
            List<List<Integer>> ans = new ArrayList<>();
            int end = nums.length - (nSum - 1);
            for (int i = start; i < end; i++) {
                while (i > start && i < end && nums[i] == nums[i - 1]) {
                    i++;
                }
                List<List<Integer>> lists = nSumTarget(nums, i + 1, target - nums[i], nSum - 1);
                for (List<Integer> list : lists) {
                    list.add(nums[i]);
                    ans.add(list);
                }
            }
            return ans;
        }
    }

}
