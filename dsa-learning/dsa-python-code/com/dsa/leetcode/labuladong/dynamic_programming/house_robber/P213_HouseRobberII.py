from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        return max(self.dp2(nums, 0, len(nums) - 2), self.dp2(nums, 1, len(nums) - 1))

    def recursive(self, nums, start, end):
        if start >= end + 1:
            return 0
        # rob
        p1 = nums[start] + self.recursive(nums, start + 2, end)
        # not rob
        p2 = self.recursive(nums, start + 1, end)
        return max(p1, p2)

    def dp(self, nums, start, end):
        n = len(nums) + 2
        dp = [0 for i in range(n)]
        for i in range(end, start - 1, -1):
            dp[i] = max(nums[i] + dp[i + 2], dp[i + 1])
        return dp[start]

    def dp2(self, nums, start, end):
        p, p1, p2 = 0, 0, 0
        for i in range(end, start - 1, -1):
            p = max(nums[i] + p2, p1)
            p2 = p1
            p1 = p
        return p


if __name__ == '__main__':
    nums = [2, 3, 2]
    solu = Solution()
    print(solu.rob(nums))
