from typing import List


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        res = 0
        for num in nums:
            res = res ^ num
        for num in range(n + 1):
            res = res ^ num
        return res


if __name__ == '__main__':
    nums = [9, 6, 4, 2, 3, 5, 7, 0, 1]
    solu = Solution()
    res = solu.missingNumber(nums)
    print(res)
