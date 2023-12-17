package com.dsa.leetcode.labuladong.array.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 2023/12/17 17:16
 */
public class P54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>(m * n);
        // 顺时针定义四个角的边界索引
        int top = 0, left = 0;
        int bottom = m - 1, right = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    list.add(matrix[bottom][i]);
                }
                for (int i = bottom; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return list;
    }
}
