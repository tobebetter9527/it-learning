# author: tobebetter9527
# since: 2024/1/17 17:40
from typing import List


class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        left = max(nums)
        right = sum(nums)
        while left <= right:
            mid = left + (right - left) // 2
            target = self.f(nums, mid)
            if target <= k:
                right = mid - 1
            else:
                left = mid + 1
        return left

    def f(self, weights, capacity):
        days = 0
        n = len(weights)
        i = 0
        while i < n:
            cap = capacity
            while i < n:
                if cap < weights[i]:
                    break
                else:
                    cap -= weights[i]
                    i += 1
            days += 1
        return days


if __name__ == '__main__':
    weights = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    days = 5
    solu = Solution()
    i = solu.shipWithinDays(weights, days)
    print(i)
