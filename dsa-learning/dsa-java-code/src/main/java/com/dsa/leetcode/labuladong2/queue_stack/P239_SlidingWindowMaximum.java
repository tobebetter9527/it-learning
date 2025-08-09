package com.dsa.leetcode.labuladong2.queue_stack;

public class P239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        MonotonicQueue mq = new MonotonicQueue();
        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                mq.push(nums[i]);
            } else {
                res[idx++] = mq.max();
                mq.pop(nums[i]);
            }
        }
    }
}
