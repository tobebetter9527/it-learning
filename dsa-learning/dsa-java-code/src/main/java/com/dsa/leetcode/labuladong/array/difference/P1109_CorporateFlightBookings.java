package com.dsa.leetcode.labuladong.array.difference;

public class P1109_CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        Difference diff = new Difference(n);
        for (int[] booking : bookings) {
            diff.increment(booking[0] - 1, booking[1] - 1, booking[2]);
        }
        return diff.result();
    }

    static class Difference {
        private int[] diff;

        public Difference(int n) {
            diff = new int[n];
        }

        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int n = diff.length;
            int[] ans = new int[n];
            ans[0] = diff[0];
            for (int i = 1; i < n; i++) {
                ans[i] = ans[i - 1] + diff[i];
            }
            return ans;
        }
    }
}
