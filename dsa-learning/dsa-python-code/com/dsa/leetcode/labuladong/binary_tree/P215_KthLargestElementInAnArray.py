# author: tobebetter9527
# since: 2024/4/1 8:46
import random
from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        left, right = 0, len(nums) - 1
        k = len(nums) - k
        while left <= right:
            p = self.partition(nums, left, right)
            # it's easy to make a mistake here
            if k == p:
                return nums[k]
            elif k < p:
                right = p - 1
            else:
                left = p + 1
        return -1

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
        self.swap(nums, right, i)
        return i

    def swap(self, nums, p, q):
        temp = nums[p]
        nums[p] = nums[q]
        nums[q] = temp


if __name__ == '__main__':
    nums = [3, 2, 1, 5, 6, 4]
    k = 2
    solu = Solution()
    res = solu.findKthLargest(nums, k)
    print(res)
