package com.dsa.leetcode.labuladong2.array;

public class P27_RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 3 };
        int size = removeElement(nums, 3);
        System.out.println(size);
    }

}
