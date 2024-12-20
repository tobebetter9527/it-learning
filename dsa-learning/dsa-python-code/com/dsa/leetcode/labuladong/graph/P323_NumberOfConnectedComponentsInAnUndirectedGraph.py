from typing import List


class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        uf = UninonFind(n)
        for edge in edges:
            uf.union(edge[0], edge[1])
        return uf.count


class UninonFind:
    def __init__(self, n: int):
        self.count = n
        self.parent = [i for i in range(n)]

    def find(self, x: int) -> int:
        q = []
        while x != self.parent[x]:
            q.append(x)
            x = self.parent[x]
        while q:
            self.parent[q.pop()] = x
        return x

    def union(self, a: int, b: int):
        a = self.find(a)
        b = self.find(b)
        if a == b:
            return
        self.parent[a] = b
        self.count -= 1

    def size(self):
        return self.count


if __name__ == '__main__':
    n = 5
    # edges = [[0, 1], [1, 2], [3, 4]]
    edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
    solu = Solution()
    print(solu.countComponents(n, edges))
