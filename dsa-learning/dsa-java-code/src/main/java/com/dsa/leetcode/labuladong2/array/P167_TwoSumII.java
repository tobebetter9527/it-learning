package com.dsa.leetcode.labuladong2.array;

public class P167_TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[left] + numbers[right];
            if (target > temp) {
                left++;
            } else if (target < temp) {
                right--;
            } else {
                return new int[] { left + 1, right + 1 };
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        twoSum(nums, 9);
    }
}
