package com.dsa.leetcode.labuladong.interview;

public class P264_UglyNumberII {
    /**
     * 没理解透
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int n2 = res[p2] * 2, n3 = res[p3] * 3, n5 = res[p5] * 5;
            int min = Math.min(Math.min(n2, n3), n5);
            res[i] = min;
            if (n2 == min) {
                p2++;
            }
            if (n3 == min) {
                p3++;
            }
            if (n5 == min) {
                p5++;
            }
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        int n = 10;
        P264_UglyNumberII p264 = new P264_UglyNumberII();
        System.out.println(p264.nthUglyNumber(n));
    }
}
