package com.dsa.leetcode.labuladong2.array;

public class P26_RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int size = removeDuplicates(nums);
        System.out.println(size);
    }
}
