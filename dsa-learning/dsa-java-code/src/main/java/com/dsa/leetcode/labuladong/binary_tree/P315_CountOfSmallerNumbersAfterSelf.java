package com.dsa.leetcode.labuladong.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class P315_CountOfSmallerNumbersAfterSelf {
    private Pair[] temp;
    private int[] count;

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int length = nums.length;
        count = new int[length];
        temp = new Pair[length];
        Pair[] arr = new Pair[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, length - 1);

        List<Integer> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add(count[i]);
        }
        return list;
    }

    private void mergeSort(Pair[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(Pair[] arr, int left, int mid, int right) {
        // copy arr
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int idx = left;
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (temp[i].val <= temp[j].val) {
                arr[idx++] = temp[i];
                count[temp[i].index] += j - mid - 1;
                i++;
            } else {
                arr[idx++] = temp[j++];
            }
        }
        while (i <= mid) {
            count[temp[i].index] += j - mid - 1;
            arr[idx++] = temp[i++];
        }
        while (j <= right) {
            arr[idx++] = temp[j++];
        }
    }

    static class Pair {
        int val;
        int index;

        public Pair(int value, int index) {
            this.val = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1};
        P315_CountOfSmallerNumbersAfterSelf p315 = new P315_CountOfSmallerNumbersAfterSelf();
        List<Integer> list = p315.countSmaller(nums);
        System.out.println(list);

    }
}
