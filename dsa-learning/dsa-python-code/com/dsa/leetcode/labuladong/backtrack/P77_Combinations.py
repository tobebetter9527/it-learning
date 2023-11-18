from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        ans = []
        path = []
        self.backtrack(n, k, 1, ans, path)
        return ans

    def backtrack(self, n, k, start, ans, path):
        if len(path) == k:
            ans.append(path[:])
            return
        for i in range(start, n + 1):
            path.append(i)
            self.backtrack(n, k, i + 1, ans, path)
            path.pop()
