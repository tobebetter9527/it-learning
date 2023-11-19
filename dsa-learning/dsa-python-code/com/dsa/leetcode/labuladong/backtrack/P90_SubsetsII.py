from typing import List


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        ans, path = [], []
        nums.sort()
        self.backtrack(nums, 0, ans, path)
        return ans

    def backtrack(self, nums, start, ans, path):
        ans.append(path[:])
        if start == len(nums):
            return
        for i in range(start, len(nums)):
            if i > start and nums[i - 1] == nums[i]:
                continue
            path.append(nums[i])
            self.backtrack(nums, i + 1, ans, path)
            path.pop()


if __name__ == '__main__':
    nums = [1, 2, 2, 1]
    solu = Solution()
    print(solu.subsetsWithDup(nums))
