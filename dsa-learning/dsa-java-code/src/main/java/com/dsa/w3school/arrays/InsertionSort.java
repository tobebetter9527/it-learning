package com.dsa.w3school.arrays;

import static com.dsa.w3school.arrays.BubbleSort.swap;

public class InsertionSort {
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int temp = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = temp;
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
