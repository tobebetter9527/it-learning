from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        ans = []
        m = len(matrix)
        n = len(matrix[0])
        top, left = 0, 0
        bottom, right = m - 1, n - 1
        while top <= bottom and left <= right:
            if top == bottom:
                for i in range(left, right + 1):
                    ans.append(matrix[top][i])
            elif left == right:
                for i in range(top, bottom + 1):
                    ans.append(matrix[i][left])
            else:
                for i in range(left, right):
                    ans.append(matrix[top][i])
                for i in range(top, bottom):
                    ans.append(matrix[i][right])
                for i in range(right, left, -1):
                    ans.append(matrix[bottom][i])
                for i in range(bottom, top, -1):
                    ans.append(matrix[i][left])
            top += 1
            left += 1
            bottom -= 1
            right -= 1
        return ans


if __name__ == '__main__':
    matrix = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]
    solu = Solution()
    print(solu.spiralOrder(matrix))