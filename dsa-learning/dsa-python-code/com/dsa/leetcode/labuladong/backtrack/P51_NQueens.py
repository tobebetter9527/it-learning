# author: tobebetter9527
# since: 2023/11/16 11:41
from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        self.ans = []
        self.backtrack(0, n)
        return self.result

    def backtrack(self, row, n):
        if row == n:
            self.result.append(self.makeStringList(n))
            return
        for col in range(n):
            if self.isAailable(row, col):
                self.ans.append(col)
                self.backtrack(row + 1, n)
                self.ans.pop()

    def makeStringList(self, n):
        res = []
        for row in range(n):
            var = ["." for i in range(n)]
            var[self.ans[row]] = "Q"
            res.append("".join(var))
        return res

    def isAailable(self, row, col):
        for i in range(len(self.ans)):
            diffRow = abs(row - i)
            diffCol = abs(col - self.ans[i])
            if diffCol == 0 or diffRow == diffCol:
                return False
        return True
