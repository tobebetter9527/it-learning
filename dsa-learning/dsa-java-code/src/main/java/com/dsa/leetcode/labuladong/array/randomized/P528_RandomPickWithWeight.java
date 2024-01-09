package com.dsa.leetcode.labuladong.array.randomized;

import java.util.Random;

public class P528_RandomPickWithWeight {
    /**
     * 前缀和
     */
    int[] preSum;
    /**
     * 总和
     */
    int total;

    Random random = new Random();

    public P528_RandomPickWithWeight(int[] w) {
        int n = w.length;
        preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
        total = preSum[n];
    }

    public int pickIndex() {
        int n = preSum.length;
        //  在闭区间 [1, preSum[n - 1]] 中随机选择一个数字
        int target = random.nextInt(preSum[n - 1]) + 1;

        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (preSum[mid] < target) {
                left = mid + 1;
            } else {
               right = mid - 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        int[] w = {1, 3};
        P528_RandomPickWithWeight p528 = new P528_RandomPickWithWeight(w);
        for (int i = 0; i < 10; i++) {
            System.out.println(p528.pickIndex());
        }
    }
}
