from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        res = 0
        for num in nums:
            res = res ^ num
        return res


if __name__ == '__main__':
    solu = Solution()
    nums = [2, 2, 1]
    res = solu.singleNumber(nums)
    print(res)
