from collections import deque
from typing import List


class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        num = len(graph)
        self.is_bipartite = True
        self.colors = [False] * num
        self.visited = [False] * num

        for i in range(num):
            if not self.is_bipartite:
                break
            if not self.visited[i]:
                self.bfs(graph, i)
        return self.is_bipartite

    def bfs(self, graph: List[List[int]], i: int):
        q = deque()
        q.append(i)
        while q:
            _from = q.popleft()
            self.visited[_from] = True
            for _to in graph[_from]:
                if not self.visited[_to]:
                    self.colors[_to] = not self.colors[_from]
                    q.append(_to)
                else:
                    if self.colors[_to] == self.colors[_from]:
                        self.is_bipartite = False
