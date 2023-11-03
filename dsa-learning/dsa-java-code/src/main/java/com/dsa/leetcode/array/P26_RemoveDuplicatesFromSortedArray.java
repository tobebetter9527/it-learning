package com.dsa.leetcode.array;

public class P26_RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1, len = nums.length; j < len; j++) {
            if (nums[i] < nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 2, 2};
        System.out.println(removeDuplicates(nums));
    }
}
