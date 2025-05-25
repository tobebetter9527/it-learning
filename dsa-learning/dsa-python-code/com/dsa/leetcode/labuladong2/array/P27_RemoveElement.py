from typing import List


class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        length = len(nums)
        if length == 0:
            return 0
        slow = 0
        for i in range(length):
            if nums[i] != val:
                nums[slow] = nums[i]
                slow = slow + 1
        return slow