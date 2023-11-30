from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0
        return self.dp(prices)

    def recursive(self, prices, i, status):
        if i >= len(prices):
            return 0
        if status == 0:
            # buy
            p1 = -prices[i] + self.recursive(prices, i + 1, 1)
            # not buy
            p2 = self.recursive(prices, i + 1, status)
            return max(p1, p2)
        else:
            # sell
            p1 = prices[i] + self.recursive(prices, i + 2, 0)
            # not sell
            p2 = self.recursive(prices, i + 1, status)
            return max(p1, p2)

    def dp(self, prices):
        n = len(prices) + 2
        m = 2
        dp = [[0 for i in range(m)] for i in range(n)]
        for i in range(n - 3, -1, -1):
            for status in range(m):
                if status == 0:
                    p1 = -prices[i] + dp[i + 1][1]
                    p2 = dp[i + 1][status]
                    dp[i][status] = max(p1, p2)
                else:
                    p1 = prices[i] + dp[i + 2][0]
                    p2 = dp[i + 1][status]
                    dp[i][status] = max(p1, p2)
        return dp[0][0]


if __name__ == '__main__':
    prices = [1, 2, 3, 0, 2]
    solu = Solution()
    print(solu.maxProfit(prices))
