package com.dsa.leetcode.labuladong.binary_search;

public class P1011_CapacityToShipPackagesWithinDDays {
    /**
     * 二分法和动态规划都可以，本次用二分法
     *
     * @param weights
     * @param days
     * @return
     */
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int targert = f(weights, mid);
            if (targert <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int f(int[] weights, int capacity) {
        int days = 0;
        int n = weights.length;
        int i = 0;
        int cap;
        while (i < n) {
            cap = capacity;
            while (i < n) {
                if (cap < weights[i]) {
                    break;
                } else {
                    cap -= weights[i];
                    i++;
                }
            }
            days++;
        }
        return days;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        P1011_CapacityToShipPackagesWithinDDays p1011 = new P1011_CapacityToShipPackagesWithinDDays();
        int i = p1011.shipWithinDays(weights, days);
        System.out.println(i);
    }
}
