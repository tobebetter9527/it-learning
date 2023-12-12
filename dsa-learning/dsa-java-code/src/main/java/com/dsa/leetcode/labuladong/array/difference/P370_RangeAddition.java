package com.dsa.leetcode.labuladong.array.difference;

/**
 * @since 2023/12/12 20:30
 */
public class P370_RangeAddition {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0};
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        Difference difference = new Difference(nums);
        for (int[] update : updates) {
            difference.increment(update[0], update[1], update[2]);
        }
        for (int i : difference.result()) {
            System.out.println(i);
        }

    }

    static class Difference {

        private int[] diff;

        public Difference(int[] nums) {
            int n = nums.length;
            this.diff = new int[n];
            // 制造差分数组
            diff[0] = nums[0];
            for (int i = 1; i < n; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
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
                ans[i] = diff[i] + ans[i - 1];
            }
            return ans;
        }
    }
}
