from typing import List


class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        if not nums:
            return 0
        left = -1
        for right in range(len(nums)):
            if nums[right] != val:
                left += 1
                nums[left] = nums[right]
        return left + 1
