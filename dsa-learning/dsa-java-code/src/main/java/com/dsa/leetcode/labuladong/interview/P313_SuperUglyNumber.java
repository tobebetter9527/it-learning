package com.dsa.leetcode.labuladong.interview;

import java.util.PriorityQueue;

/**
 * @since 2024/8/1 20:30
 */
public class P313_SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int prime : primes) {
            q.add(new int[]{prime, prime, 1});
        }
        int[] res = new int[n];
        res[0] = 1;
        int p = 1;
        while (p < n) {
            int[] poll = q.poll();
            int product = poll[0];
            int prime = poll[1];
            int index = poll[2];
            if (product != res[p - 1]) {
                res[p++] = product;
            }
            q.add(new int[]{res[index] * prime, prime, index + 1});
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        int n = 12;
        int[] primes = {2, 7, 13, 19};
        P313_SuperUglyNumber p313 = new P313_SuperUglyNumber();
        System.out.println(p313.nthSuperUglyNumber(n, primes));
    }

}
