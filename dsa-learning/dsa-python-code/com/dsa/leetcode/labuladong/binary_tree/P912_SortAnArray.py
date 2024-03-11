# author: tobebetter9527
# since: 2024/3/11 8:41
from typing import List


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        if not nums:
            return None
        length = len(nums)
        self.temp = [0 for i in range(length)]
        self.mergeSort(nums, 0, length - 1)
        return nums

    def mergeSort(self, nums, left, right):
        if left == right:
            return
        mid = left + (right - left) // 2
        self.mergeSort(nums, left, mid)
        self.mergeSort(nums, mid + 1, right)
        self.merge(nums, left, mid, right)

    def merge(self, nums, left, mid, right):
        # first copy
        for i in range(left, right + 1):
            self.temp[i] = nums[i]
        # sort the Array
        i, j = left, mid + 1
        idx = left
        while i <= mid and j <= right:
            if self.temp[i] < self.temp[j]:
                nums[idx] = self.temp[i]
                i += 1
            else:
                nums[idx] = self.temp[j]
                j += 1
            idx += 1
        while i <= mid:
            nums[idx] = self.temp[i]
            i += 1
            idx += 1
        while j <= right:
            nums[idx] = self.temp[j]
            j += 1
            idx += 1
