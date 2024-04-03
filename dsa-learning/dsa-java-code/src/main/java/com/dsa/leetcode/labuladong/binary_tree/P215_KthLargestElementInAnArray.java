package com.dsa.leetcode.labuladong.binary_tree;

import java.util.Random;

public class P215_KthLargestElementInAnArray {
    Random random;

    public int findKthLargest(int[] nums, int k) {
        random = new Random();
        k = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        return quickSelect(nums, left, right, k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return nums[k];
        }
        int p = partition(nums, left, right);
        if (k <= p) {
            return quickSelect(nums, left, p, k);
        } else {
            return quickSelect(nums, p + 1, right, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int idx = left + random.nextInt(right - left + 1);
        swap(nums, left, idx);

        int pivot = nums[left];
        int i = left - 1;
        int j = right + 1;
        while (i < j) {
            do {
                i++;
            } while (nums[i] < pivot);
            do {
                j--;
            } while (nums[j] > pivot);
            if (i < j) {
                swap(nums, i, j);
            }
        }
        return j;
    }


    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

//    private int partition(int[] nums, int left, int right) {
//        int idx = left + random.nextInt(right - left + 1);
//        swap(nums, idx, right);
//
//        int i = left - 1;
//        int pivot = nums[right];
//        while (left < right) {
//            if (nums[left] <= pivot) {
//                swap(nums, left, ++i);
//            }
//            left++;
//        }
//        swap(nums, left, ++i);
//        return i;
//    }

//    private int partition(int[] nums, int lo, int hi) {
//        int pivot = nums[lo];
//        // 关于区间的边界控制需格外小心，稍有不慎就会出错
//        // 我这里把 i, j 定义为开区间，同时定义：
//        // [lo, i) <= pivot；(j, hi] > pivot
//        // 之后都要正确维护这个边界区间的定义
//        int i = lo + 1, j = hi;
//        // 当 i > j 时结束循环，以保证区间 [lo, hi] 都被覆盖
//        while (i <= j) {
//            while (i < hi && nums[i] <= pivot) {
//                i++;
//                // 此 while 结束时恰好 nums[i] > pivot
//            }
//            while (j > lo && nums[j] > pivot) {
//                j--;
//                // 此 while 结束时恰好 nums[j] <= pivot
//            }
//            // 此时 [lo, i) <= pivot && (j, hi] > pivot
//
//            if (i >= j) {
//                break;
//            }
//            swap(nums, i, j);
//        }
//        // 将 pivot 放到合适的位置，即 pivot 左边元素较小，右边元素较大
//        swap(nums, lo, j);
//        return j;
//    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        P215_KthLargestElementInAnArray p215 = new P215_KthLargestElementInAnArray();
        int kthLargest = p215.findKthLargest(nums, k);
        System.out.println(kthLargest);
    }
}
