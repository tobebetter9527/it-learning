package com.dsa.leetcode.labuladong2.queue_stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P239_SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(res);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        MonotonicQueue mq = new MonotonicQueue();
        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                mq.push(nums[i]);
            } else {
                mq.push(nums[i]);
                res[idx++] = mq.max();
                mq.pop(nums[i - k + 1]);
            }
        }
        return res;
    }

    private static class MonotonicQueue {

        Deque<Integer> q = new LinkedList<>();

        public void push(int value) {
            while (!q.isEmpty() && q.peekLast() < value) {
                q.pollLast();
            }
            q.offerLast(value);
        }

        public void pop(int value) {
            if (value ==  q.peekFirst()) {
                q.pollFirst();
            }
        }

        public int max() {
            return q.peek();
        }
    }
}
