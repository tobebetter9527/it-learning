import random
from typing import List


class Solution:

    def __init__(self, nums: List[int]):
        self.nums = nums
        self.original = nums.copy()

    def reset(self) -> List[int]:
        return self.original

    def shuffle(self) -> List[int]:
        self.nums = self.original.copy()
        n = len(self.nums)
        for i in range(n):
            r = random.randrange(i, n)
            self.nums[i], self.nums[r] = self.nums[r], self.nums[i]
        return self.nums
