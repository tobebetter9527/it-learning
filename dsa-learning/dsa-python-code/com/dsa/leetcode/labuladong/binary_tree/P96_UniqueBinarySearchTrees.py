# author: tobebetter9527
# since: 2024/3/25 8:49
class Solution:
    def numTrees(self, n: int) -> int:
        nums = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
        return self.countBST(1, n, nums)

    def countBST(self, left, right, nums):
        if left >= right:
            return 1
        if nums[left][right] != 0:
            return nums[left][right]
        ans = 0
        for i in range(left, right + 1):
            res1 = self.countBST(left, i - 1, nums)
            res2 = self.countBST(i + 1, right, nums)
            ans += res1 * res2
        nums[left][right] = ans
        return ans
