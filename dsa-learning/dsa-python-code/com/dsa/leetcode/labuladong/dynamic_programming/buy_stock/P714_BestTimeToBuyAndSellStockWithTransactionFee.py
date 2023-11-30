# author: tobebetter9527
# since: 2023/11/30 17:56
from typing import List


class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        if not prices:
            return 0
        return self.dp(prices, fee)

    def recursive(self, prices, i, status, fee):
        if i == len(prices):
            return 0
        if status == 0:
            p1 = -prices[i] + self.recursive(prices, i + 1, 1, fee)
            p2 = self.recursive(prices, i + 1, status, fee)
            return max(p1, p2)
        else:
            p1 = prices[i] - fee + self.recursive(prices, i + 1, 0, fee)
            p2 = self.recursive(prices, i + 1, status, fee)
            return max(p1, p2)

    def dp(self, prices, fee):
        n = len(prices) + 1
        m = 2
        dp = [[0 for i in range(m)] for i in range(n)]
        for i in range(n - 2, -1, -1):
            for status in range(m):
                if status == 0:
                    p1 = -prices[i] + dp[i + 1][1]
                    p2 = dp[i + 1][status]
                    dp[i][status] = max(p1, p2)
                else:
                    p1 = prices[i] - fee + dp[i + 1][0]
                    p2 = dp[i + 1][status]
                    dp[i][status] = max(p1, p2)
        return dp[0][0]


if __name__ == '__main__':
    prices = [1, 3, 2, 8, 4, 9]
    fee = 2
    solu = Solution()
    print(solu.maxProfit(prices, fee))
