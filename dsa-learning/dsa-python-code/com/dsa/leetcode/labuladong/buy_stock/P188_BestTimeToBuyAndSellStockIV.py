from typing import List


class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        if not prices:
            return 0
        return self.dp(prices, k * 2)

    def recursive(self, prices, idx, doubleK, status):
        if idx == len(prices):
            return 0
        if status == doubleK:
            return 0
        # can buy
        if (status & 1) == 0:
            # buy
            p1 = self.recursive(prices, idx + 1, doubleK, status + 1) - prices[idx]
            # not buy
            p2 = self.recursive(prices, idx + 1, doubleK, status)
            return max(p1, p2)
        else:
            # sell
            p1 = self.recursive(prices, idx + 1, doubleK, status + 1) + prices[idx]
            # not sell
            p2 = self.recursive(prices, idx + 1, doubleK, status)
            return max(p1, p2)

    def dp(self, prices, doubleK):
        m = len(prices) + 1
        n = doubleK + 1
        dp = [[0] * n] * m
        # 从下到shang，从左到右
        for idx in range(m - 2, -1, -1):
            for status in range(doubleK):
                # can buy
                if (status & 1) == 0:
                    # buy
                    p1 = dp[idx + 1][status + 1] - prices[idx]
                    # not buy
                    p2 = dp[idx + 1][status]
                    dp[idx][status] = max(p1, p2)
                else:
                    # sell
                    p1 = dp[idx + 1][status + 1] + prices[idx]
                    # not sell
                    p2 = dp[idx + 1][status]
                    dp[idx][status] = max(p1, p2)
        return dp[0][0]


if __name__ == '__main__':
    k = 2
    prices = [2, 4, 1]
    solu = Solution()
    print(solu.maxProfit(k, prices))
