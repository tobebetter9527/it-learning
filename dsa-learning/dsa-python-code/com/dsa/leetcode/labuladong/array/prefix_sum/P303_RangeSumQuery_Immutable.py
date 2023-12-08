from typing import List


class NumArray:

    def __init__(self, nums: List[int]):
        self.sums = [0]
        sums = self.sums
        for num in nums:
            sums.append(sums[-1] + num)

    def sumRange(self, left: int, right: int) -> int:
        return self.sums[right + 1] - self.sums[left]
