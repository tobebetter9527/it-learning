package com.dsa.w3school.arrays;

public class BubbleSort {
    /**
     * 1.An array with values to sort
     * <p/>
     * 2.An inner loop that goes through the array and swaps values if the first value is higher than the next value.
     * This loop must loop through one less value each time it runs.
     * <p/>
     * 3.An outer loop that controls how many times the inner loop must run. For an array with n values,
     * this outer loop must run n-1 times.
     */
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] nums = {64, 34, 25, 12, 22, 11, 90, 5};
        bubbleSort.sortArray(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
