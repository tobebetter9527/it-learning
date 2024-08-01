import heapq
from typing import List


class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        res = [1] * n
        p = 1
        q = []
        for prime in primes:
            heapq.heappush(q, (prime, prime, 1))
        while p < n:
            product, prime, index = heapq.heappop(q)
            if product != res[p - 1]:
                res[p] = product
                p += 1
            heapq.heappush(q, (res[index] * prime, prime, index + 1))
        return res[-1]


if __name__ == '__main__':
    n = 12
    primes = [2, 7, 13, 19]
    solu = Solution()
    print(solu.nthSuperUglyNumber(n, primes))
