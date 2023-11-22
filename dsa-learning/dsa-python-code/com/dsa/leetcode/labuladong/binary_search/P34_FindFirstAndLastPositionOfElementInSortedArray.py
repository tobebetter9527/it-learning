# author: tobebetter9527
# since: 2023/11/22 9:04
from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1, -1]
        first = self.firstBinarySearch(nums, target)
        last = self.lastBinarySearch(nums, target)
        return [first, last]

    def firstBinarySearch(self, nums, target):
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                right = mid - 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        if left >= len(nums):
            return -1
        return left if nums[left] == target else -1

    def lastBinarySearch(self, nums, target):
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        if right < 0:
            return -1
        return right if nums[right] == target else -1


if __name__ == '__main__':
    nums = [5, 7, 7, 8, 8, 10]
    target = 8
    solu = Solution()
    print(solu.searchRange(nums, target))
