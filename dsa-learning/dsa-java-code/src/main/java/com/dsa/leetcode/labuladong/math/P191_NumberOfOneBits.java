package com.dsa.leetcode.labuladong.math;

/**
 * @since 2024/7/25 20:58
 */
public class P191_NumberOfOneBits {
    public int hammingWeight(int n) {
        int sum = 0;
//        for (int i = 0; i < 32; i++) {
//            sum += n & 1;
//            n = n >> 1;
//        }
        while (n != 0) {
            n = n & (n - 1);
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        P191_NumberOfOneBits p191 = new P191_NumberOfOneBits();
        int i = p191.hammingWeight(128);
        System.out.println(i);
    }
}
