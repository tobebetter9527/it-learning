package com.dsa.leetcode.labuladong.array;

/**
 * @since 2023/11/4 20:41
 */
public class P167_TwoSum2InputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int temp;
        while (left < right) {
            temp = numbers[left] + numbers[right];
            if (temp == target) {
                return new int[]{left + 1, right + 1};
            } else if (temp > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
