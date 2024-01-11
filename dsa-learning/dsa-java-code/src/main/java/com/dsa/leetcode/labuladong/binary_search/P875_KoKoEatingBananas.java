package com.dsa.leetcode.labuladong.binary_search;

public class P875_KoKoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int target = calculate(piles, mid);
            if (target <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int calculate(int[] piles, int mid) {
        int h = 0;
        for (int pile : piles) {
            h += pile / mid;
            if (pile % mid != 0) {
                h++;
            }
        }
        return h;
    }

    public static void main(String[] args) {
        int[] piles = {312884470};
        int h = 312884469;
        P875_KoKoEatingBananas p875 = new P875_KoKoEatingBananas();
        int calculate = p875.minEatingSpeed(piles, h);
        System.out.println(calculate);
    }
}
