class Solution:
    def fib(self, n: int) -> int:
        if n < 2:
            return n
        x, y, z = 0, 1, 0
        for i in range(2, n + 1):
            z = x + y
            x = y
            y = z
        return z
