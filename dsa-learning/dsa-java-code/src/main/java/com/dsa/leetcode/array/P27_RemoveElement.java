package com.dsa.leetcode.array;

/**
 * @since 2023/11/4 09:23
 */
public class P27_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int idx = -1;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] != val) {
                nums[++idx] = nums[i];
            }
        }
        return idx + 1;
    }

    public static int removeElement2(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int i = removeElement2(nums, val);
        System.out.println(i);
    }

}
