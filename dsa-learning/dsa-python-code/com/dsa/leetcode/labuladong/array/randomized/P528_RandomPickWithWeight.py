# author: tobebetter9527
# since: 2024/1/9 17:47
import random
from typing import List


class Solution:

    def __init__(self, w: List[int]):
        n = len(w)
        preSum = [0 for i in range(n + 1)]
        preSum[0] = 0
        for i in range(1, n + 1):
            preSum[i] = preSum[i - 1] + w[i - 1]
        self.preSum = preSum
        self.total = preSum[n]

    def pickIndex(self) -> int:
        preSum = self.preSum
        total = self.total
        n = len(preSum)
        target = random.randint(1, total)

        left, right = 0, n - 1
        while left <= right:
            mid = left + (right - left) // 2
            if preSum[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return left - 1


if __name__ == '__main__':
    w = [1, 3]
    solu = Solution(w)
    for i in range(10):
        print(solu.pickIndex())
