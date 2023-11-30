from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        return self.dp(nums)

    def recursive(self, nums, i):
        if i == len(nums):
            return 0
        # rob
        p1 = nums[i] + self.recursive(nums, i + 2)
        # not rob
        p2 = self.recursive(nums, i + 1)

    def dp(self, nums):
        n = len(nums) + 2
        dp = [0 for i in range(n)]
        for i in range(n - 3, -1, -1):
            dp[i] = max(nums[i] + dp[i + 2], dp[i + 1])
        return dp[0]

    def dp2(self, nums):
        n = len(nums) + 2
        p, p1, p2 = 0, 0, 0
        for i in range(n - 3, -1, -1):
            p = max(nums[i] + p2, p1)
            p2 = p1
            p1 = p
        return p
