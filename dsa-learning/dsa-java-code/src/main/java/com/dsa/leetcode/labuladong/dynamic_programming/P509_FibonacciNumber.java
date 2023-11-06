package com.dsa.leetcode.labuladong.dynamic_programming;

/**
 * @since 2023/11/6 20:39
 */
public class P509_FibonacciNumber {

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int fib3(int n) {
        if (n < 2) {
            return n;
        }
        int x = 0, y = 1, z = 0;
        for (int i = 2; i <= n; i++) {
            z = x + y;
            x = y;
            y = z;
        }
        return z;
    }



    public static void main(String[] args) {
        int n = 45;
        System.out.println(fib3(n));
    }
}
