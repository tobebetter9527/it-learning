package com.dsa.leetcode.labuladong.array.prefix_sum;

/**
 * @since 2023/12/9 09:20
 */
public class P304_RangeSumQuery2D_Immutable {

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }


    static class NumMatrix {
        int[][] sums;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            sums = new int[m + 1][n + 1];
            // 横列叠加
//            for (int row = 0; row < m; row++) {
//                for (int col = 0; col < n; col++) {
//                    sums[row + 1][col + 1] = sums[row + 1][col] + matrix[row][col];
//                }
//            }
            // 竖列叠加
//            for (int col = 0; col < n; col++) {
//                for (int row = 0; row < m; row++) {
//                    sums[row + 1][col + 1] = sums[row + 1][col + 1] + sums[row][col + 1];
//                }
//            }

            // 优化代码
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    sums[row + 1][col + 1] = sums[row][col + 1] + sums[row + 1][col] + matrix[row][col] - sums[row][col];
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row1][col1];
        }
    }
}
