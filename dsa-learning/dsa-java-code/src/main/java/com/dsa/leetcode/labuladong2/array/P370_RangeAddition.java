package com.dsa.leetcode.labuladong2.array;

public class P370_RangeAddition {

    public static void main(String[] args) {
        int length = 5;
        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        P370_RangeAddition p = new P370_RangeAddition();
        int[] res = p.getModifiedArray(length, updates);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public int[] getModifiedArray(int length, int[][] updates) {
        DifferenceArray da = new DifferenceArray(new int[length]);
        for (int[] update : updates) {
            da.increment(update[0], update[1], update[2]);
        }
        return da.result();
    }



    static class DifferenceArray {

        private int[] diff;
        
        public DifferenceArray(int[] nums) {
            int length = nums.length;
            if (length > 0) {
                diff = new int[length];
                diff[0] = nums[0];
                for (int i = 1; i < length; i++) {
                    diff[i] = nums[i] - nums[i - 1];
                }
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < res.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
