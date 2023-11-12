from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount + 1 for i in range(amount + 1)]
        dp[0] = 0
        for coin in coins:
            for restAmount in range(coin, amount + 1):
                dp[restAmount] = min(dp[restAmount], 1 + dp[restAmount - coin])
        return dp[amount] if dp[amount] != amount + 1 else -1
