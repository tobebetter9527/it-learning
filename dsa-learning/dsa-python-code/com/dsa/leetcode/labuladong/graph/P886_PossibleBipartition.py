from typing import List


class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        self.is_bipartite = True
        self.colors = [False] * (n + 1)
        self.visited = [False] * (n + 1)

        graph = self.build(n, dislikes)
        for i in range(1, n + 1):
            if not self.visited[i]:
                self.dfs(graph, i)
        return self.is_bipartite

    def build(self, n: int, dislikes: List[List[int]]):
        graph = [[] for _ in range(n + 1)]
        for edge in dislikes:
            _from = edge[0]
            _to = edge[1]
            graph[_from].append(_to)
            graph[_to].append(_from)
        return graph

    def dfs(self, graph, i):
        if not self.is_bipartite:
            return
        self.visited[i] = True
        for _to in graph[i]:
            if not self.visited[_to]:
                self.colors[_to] = not self.colors[i]
                self.dfs(graph, _to)
            else:
                if self.colors[_to] == self.colors[i]:
                    self.is_bipartite = False
