package com.dsa.leetcode.labuladong.array.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P870_AdvantageShuffle {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // 处理值和索引关系的，这是重要技巧
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{nums2[i], i});
        }
        list.sort((x, y) -> x[0] - y[0]);

        Arrays.sort(nums1);

        int[] ans = new int[n];
        int left = 0;
        int right = n - 1;
        int i = n - 1;
        while (i >= 0) {
            // 田忌赛马
            if (nums1[right] > list.get(i)[0]) {
                ans[list.get(i)[1]] = nums1[right];
                right--;
            } else {
                ans[list.get(i)[1]] = nums1[left];
                left++;
            }
            i--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {12, 24, 8, 32};
        int[] nums2 = {13, 25, 32, 11};
        P870_AdvantageShuffle p870 = new P870_AdvantageShuffle();
        int[] ints = p870.advantageCount(nums1, nums2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
