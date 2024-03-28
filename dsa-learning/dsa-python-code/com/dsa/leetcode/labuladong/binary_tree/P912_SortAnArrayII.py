# author: tobebetter9527
# since: 2024/3/28 8:40
import random
from typing import List


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        if not nums or len(nums) < 2:
            return nums
        self.quickSort(nums, 0, len(nums) - 1)
        return nums

    def quickSort(self, nums, left, right):
        if left >= right:
            return
        p = self.partition(nums, left, right)
        self.quickSort(nums, left, p - 1)
        self.quickSort(nums, p + 1, right)

    def partition(self, nums, left, right):
        idx = left + random.randint(0, right - left)
        self.swap(nums, right, idx)

        pivot = nums[right]
        i = left - 1
        while left < right:
            if nums[left] <= pivot:
                i += 1
                self.swap(nums, left, i)
            left += 1
        i += 1
        self.swap(nums, i, right)
        return i

    def swap(self, nums, p, q):
        temp = nums[p]
        nums[p] = nums[q]
        nums[q] = temp


if __name__ == '__main__':
    nums = [5, 1, 1, 2, 0, 0]
    solu = Solution()
    solu.sortArray(nums)
    print(nums)
