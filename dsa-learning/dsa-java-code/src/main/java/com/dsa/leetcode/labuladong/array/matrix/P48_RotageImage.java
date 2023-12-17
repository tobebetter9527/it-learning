package com.dsa.leetcode.labuladong.array.matrix;

import java.util.Arrays;

/**
 * @since 2023/12/17 09:44
 */
public class P48_RotageImage {
    /**
     * 镜像反转，再水平反转
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 镜像反转
        int temp;
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < row; col++) {
                temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // 水平反转
        for (int row = 0; row < n; row++) {
            int i = 0, j = n - 1;
            while (i < j) {
                temp = matrix[row][i];
                matrix[row][i] = matrix[row][j];
                matrix[row][j] = temp;
                i++;
                j--;
            }
        }
    }


    /**
     * 顺时针旋转
     * (row, col), (col, n - 1 - row), (n - 1 - row, n - 1 - col), (n - 1 - col, row)
     *
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        int temp = 0;
        for (int row = 0; row < n / 2; row++) {
            for (int col = row; col < n - 1 - row; col++) {
                temp = matrix[row][col];
                matrix[row][col] = matrix[n - 1 - col][row];
                matrix[n - 1 - col][row] = matrix[n - 1 - row][n - 1 - col];
                matrix[n - 1 - row][n - 1 - col] = matrix[col][n - 1 - row];
                matrix[col][n - 1 - row] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        P48_RotageImage p48 = new P48_RotageImage();
        p48.rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println("");
            Arrays.stream(ints).forEach(System.out::print);
        }
        System.out.println("");
    }
}
