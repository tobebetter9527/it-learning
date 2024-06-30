from typing import List


class Solution:

    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)

        self.is_bipartite = True
        self.colors = [False] * n
        self.visited = [False] * n

        for i in range(n):
            if not self.visited[i]:
                self.dfs(graph, i)
        return self.is_bipartite

    def dfs(self, graph: List[List[int]], i: int):
        if not self.is_bipartite:
            return
        self.visited[i] = True
        for _to in graph[i]:
            if not self.visited[_to]:
                self.colors[_to] = not self.colors[i]
                self.dfs(graph,_to)
            else:
                if self.colors[_to] == self.colors[i]:
                    self.is_bipartite = False



