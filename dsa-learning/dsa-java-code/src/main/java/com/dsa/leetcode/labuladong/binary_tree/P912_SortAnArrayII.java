package com.dsa.leetcode.labuladong.binary_tree;

import java.util.Random;

public class P912_SortAnArrayII {
    Random random;

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        random = new Random();
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(nums, left, right);
        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int idx = left + random.nextInt(right - left + 1);
        swap(nums, right, idx);

        int i = left - 1;
        int pivot = nums[right];
        while (left < right) {
            if (nums[left] <= pivot) {
                swap(nums, left, ++i);
            }
            left++;
        }
        swap(nums, right, ++i);
        return i;
    }

    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}
