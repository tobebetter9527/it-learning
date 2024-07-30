class Solution:
    def countPrimes(self, n: int) -> int:
        isPrimes = [True for i in range(n)]
        count = 0
        for i in range(2, n):
            if isPrimes[i]:
                count += 1
                for j in range(i * i, n, i):
                    isPrimes[j] = False
        return count
