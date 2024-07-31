class Solution:
    def nthUglyNumber(self, n: int) -> int:
        res = [1] * n
        p2, p3, p5 = 0, 0, 0
        for i in range(1, n):
            n2, n3, n5 = res[p2] * 2, res[p3] * 3, res[p5] * 5
            min_value = min(n2, n3, n5)
            res[i] = min_value
            if n2 == min_value:
                p2 += 1
            if n3 == min_value:
                p3 += 1
            if n5 == min_value:
                p5 += 1
        return res[-1]
