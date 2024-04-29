# author: tobebetter9527
# since: 2024/4/29 17:36
from typing import List


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        ans = [0 for _ in range(n)]
        stack = []
        for i in range(n - 1, -1, -1):
            while stack and temperatures[i] >= temperatures[stack[-1]]:
                stack.pop()
            ans[i] = (stack[-1] - i) if stack else 0
            stack.append(i)
        return ans
