package com.dsa.leetcode.labuladong.math;

import java.util.Arrays;
import java.util.Random;

/**
 * @since 2024/7/27 09:30
 */
public class P384_ShuffleAnArray {

    class Solution {
        int[] nums;
        Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int n = nums.length;
            int[] copy = Arrays.copyOf(nums, n);
            for (int i = 0; i < n; i++) {
                int r = i + random.nextInt(n - i);
                swap(copy, i, r);
            }
            return copy;
        }

        public void swap(int[] nums, int p, int q) {
            int temp = nums[p];
            nums[p] = nums[q];
            nums[q] = temp;
        }
    }

}

