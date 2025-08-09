package com.dsa.leetcode.labuladong2.queue_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P496_NextGreaterElement {

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        System.out.println(nextGreaterElement(nums1, nums2));

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greater = nextGreaterElement(nums2);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], greater[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    private static int[] nextGreaterElement(int[] nums2) {
        int[] greater = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = greater.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            greater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }
        return greater;
    }
}
