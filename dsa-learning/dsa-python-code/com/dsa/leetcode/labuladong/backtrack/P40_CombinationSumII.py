from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        ans, path = [], []
        candidates.sort()
        self.backtrack(candidates, target, 0, ans, path)
        return ans

    def backtrack(self, candidates, restTarget, start, ans, path):
        if restTarget == 0:
            ans.append(path[:])
            return
        if restTarget < 0 or start == len(candidates):
            return
        for i in range(start, len(candidates)):
            if i > start and candidates[i - 1] == candidates[i]:
                continue
            path.append(candidates[i])
            self.backtrack(candidates, restTarget - candidates[i], i + 1, ans, path)
            path.pop()


if __name__ == '__main__':
    candidates = [10, 1, 2, 7, 6, 1, 5]
    target = 8
    solu = Solution()
    print(solu.combinationSum2(candidates, target))
