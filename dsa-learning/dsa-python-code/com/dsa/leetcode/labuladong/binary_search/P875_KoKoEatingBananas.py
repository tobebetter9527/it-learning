from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)
        while left < right:
            mid = left + (right - left) // 2
            target = self.calculate(piles, mid)
            if target <= h:
                right = mid
            else:
                left = mid + 1
        return left

    def calculate(self, piles, mid):
        h = 0
        for pile in piles:
            h += pile // mid
            if pile % mid != 0:
                h += 1
        return h


if __name__ == '__main__':
    piles = [3, 6, 7, 11]
    h = 8
    solu = Solution()
    ans = solu.minEatingSpeed(piles, h)
    print(ans)
