from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []
        path = []
        self.backtrack(nums, 0, path, ans)
        return ans

    def backtrack(self, nums, start, path, ans):
        ans.append(path[:])
        if start == len(nums):
            return
        for i in range(start, len(nums)):
            path.append(nums[i])
            self.backtrack(nums, i + 1, path, ans)
            path.pop()
