# author: tobebetter9527
# since: 2024/4/28 18:02
from typing import List


class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        res = {}
        stack = []
        for num in reversed(nums2):
            while stack and num > stack[-1]:
                stack.pop()
            res[num] = -1 if not stack else stack[-1]
            stack.append(num)
        return [res[num] for num in nums1]
