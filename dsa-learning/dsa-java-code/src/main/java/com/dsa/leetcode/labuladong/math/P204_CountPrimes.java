package com.dsa.leetcode.labuladong.math;

import java.util.Arrays;

/**
 * @since 2024/7/30 20:54
 */
public class P204_CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = 0;
        for (long i = 2; i < n; i++) {
            if (isPrime[(int) i]) {
                count++;
                // x的数，2x, 3x肯定算过，从x * x开始
                for (long j = i * i; j < n; j += i) {
                    isPrime[(int) j] = false;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int j = 499979 * 499979;
        System.out.println(j);
        P204_CountPrimes p204 = new P204_CountPrimes();
        int i = p204.countPrimes(499979);
        System.out.println(i);
    }
}
