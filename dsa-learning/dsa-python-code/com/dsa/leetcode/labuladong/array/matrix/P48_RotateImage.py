from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        # 镜像反转
        for row in range(1, n):
            for col in range(row):
                temp = matrix[row][col]
                matrix[row][col] = matrix[col][row]
                matrix[col][row] = temp
        # 水平反转
        for row in range(n):
            i, j = 0, n - 1
            while i < j:
                temp = matrix[row][i]
                matrix[row][i] = matrix[row][j]
                matrix[row][j] = temp
                i += 1
                j -= 1
