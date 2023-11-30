# author: tobebetter9527
# since: 2023/11/30 8:55
from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0
        minimum = prices[0]
        profit = 0
        for i in range(1, len(prices)):
            if prices[i] - minimum > profit:
                profit = prices[i] - minimum
            elif prices[i] <= minimum:
                minimum = prices[i]
        return profit


if __name__ == '__main__':
    prices = [7, 1, 5, 3, 6, 4]
    solu = Solution()
    print(solu.maxProfit(prices))
