package com.dsa.leetcode.labuladong.math;

/**
 * @since 2024/7/25 21:13
 */
public class P231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
