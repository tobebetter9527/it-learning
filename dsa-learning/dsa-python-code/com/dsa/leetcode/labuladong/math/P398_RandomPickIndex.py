import random
from typing import List


class Solution:

    def __init__(self, nums: List[int]):
        self.nums = nums

    def pick(self, target: int) -> int:
        count, res = 0, 0
        for i, num in enumerate(self.nums):
            if num == target:
                count += 1
                if random.randrange(count) == 0:
                    res = i
        return res
