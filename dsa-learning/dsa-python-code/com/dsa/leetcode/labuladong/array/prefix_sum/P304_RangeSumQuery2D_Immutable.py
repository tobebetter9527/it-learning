from typing import List


class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        m, n = len(matrix), len(matrix[0])
        self.sums = [[0 for i in range(n + 1)] for i in range(m + 1)]
        sums = self.sums
        # 从右到左，横列叠加
        for row in range(m):
            for col in range(n):
                sums[row + 1][col + 1] = sums[row + 1][col] + matrix[row][col]
        # 从上到下，竖列叠加
        for col in range(n):
            for row in range(m):
                sums[row + 1][col + 1] += sums[row][col + 1]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        sums = self.sums
        return sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row1][col1]


if __name__ == '__main__':
    matrix = [[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]
    numMatrix = NumMatrix(matrix)
    print(numMatrix.sumRegion(2, 1, 4, 3))
    print(numMatrix.sumRegion(1, 1, 2, 2))
    print(numMatrix.sumRegion(1, 2, 2, 4))
