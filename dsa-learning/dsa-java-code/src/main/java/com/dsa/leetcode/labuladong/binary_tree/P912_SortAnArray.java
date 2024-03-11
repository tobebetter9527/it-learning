package com.dsa.leetcode.labuladong.binary_tree;

public class P912_SortAnArray {
    private int[] temp;

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        temp = new int[len];
        // copy
        mergeSort(nums, 0, len - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int idx = left;
        while (i <= mid && j <= right) {
            nums[idx++] = temp[i] < temp[j] ? temp[i++] : temp[j++];
        }
        while (i <= mid) {
            nums[idx++] = temp[i++];
        }
        while (j <= right) {
            nums[idx++] = temp[j++];
        }
    }
}
