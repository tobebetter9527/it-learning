# author: tobebetter9527
# since: 2023/12/13 9:09
from typing import List


class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        diff = self.Difference(n)
        for booking in bookings:
            diff.increment(booking[0] - 1, booking[1] - 1, booking[2])
        return diff.result()

    class Difference:
        def __init__(self, n: int) -> None:
            self.diff = [0 for i in range(n)]

        def increment(self, i: int, j: int, val: int):
            self.diff[i] += val
            if j + 1 < len(self.diff):
                self.diff[j + 1] -= val

        def result(self):
            n = len(self.diff)
            nums = [0 for i in range(n)]
            nums[0] = self.diff[0]
            for i in range(1, n):
                nums[i] = nums[i - 1] + self.diff[i]
            return nums