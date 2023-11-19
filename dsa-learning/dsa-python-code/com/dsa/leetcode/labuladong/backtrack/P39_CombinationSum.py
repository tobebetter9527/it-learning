from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans, path = [], []
        self.backtrack(candidates, target, 0, ans, path)
        return ans

    def backtrack(self, candidates, restTarget, start, ans, path):
        if restTarget < 0:
            return
        if restTarget == 0:
            ans.append(path[:])
            return
        for i in range(start, len(candidates)):
            path.append(candidates[i])
            self.backtrack(candidates, restTarget - candidates[i], i, ans, path)
            path.pop()


if __name__ == '__main__':
    candidates = [2, 3, 6, 7]
    target = 7
    solu = Solution()
    print(solu.combinationSum(candidates, target))
