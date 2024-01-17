package com.dsa.leetcode.labuladong.binary_search;

public class P410_SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cap = f(nums, mid);
            if (cap <= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int f(int[] nums, int capacity) {
        int k = 0;
        int n = nums.length;
        int i = 0;
        int cap;
        while (i < n) {
            cap = capacity;
            while (i < n) {
                if (cap < nums[i]) {
                    break;
                } else {
                    cap -= nums[i];
                    i++;
                }
            }
            k++;
        }
        return k;
    }
}
