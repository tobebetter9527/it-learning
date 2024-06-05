# author: tobebetter9527
# since: 2024/6/5 16:27
import collections
from typing import List


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        deque = collections.deque()
        res = []
        for i in range(k):
            while deque and nums[deque[-1]] <= nums[i]:
                deque.pop()
            deque.append(i)

        res.append(nums[deque[0]])

        for i in range(k, len(nums)):
            if i - deque[0] == k:
                deque.popleft()
            while deque and nums[deque[-1]] <= nums[i]:
                deque.pop()
            deque.append(i)
            res.append(nums[deque[0]])

        return res
