package com.dsa.w3school.arrays;

import static com.dsa.w3school.arrays.BubbleSort.swap;

public class SelectionSort {
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[minIdx] > nums[j]) {
                    minIdx = j;
                }
            }
            swap(nums, i, minIdx);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {64, 34, 25, 12, 22, 11, 90, 5};
        sortArray(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}