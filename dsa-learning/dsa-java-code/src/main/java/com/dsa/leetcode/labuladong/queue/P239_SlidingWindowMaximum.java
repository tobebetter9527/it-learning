package com.dsa.leetcode.labuladong.queue;

import java.util.LinkedList;

public class P239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        res[idx++] = nums[queue.peekFirst()];

        for (int i = k; i < n; i++) {
            if (i - queue.peekFirst() == k) {
                queue.removeFirst();
            }

            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);

            res[idx++] = nums[queue.peekFirst()];
        }

        return res;
    }


}
