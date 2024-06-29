from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = self.build_graph(numCourses, prerequisites)
        self.visited = [False] * numCourses
        self.paths = [False] * numCourses
        self.has_circle = True

        for i in range(numCourses):
            self.traverse(graph, i)
        return self.has_circle

    def traverse(self, graph, i):
        if self.paths[i]:
            self.has_circle = False
            return
        if self.visited[i]:
            return
        self.paths[i] = True
        self.visited[i] = True
        for j in graph[i]:
            self.traverse(graph, j)
        self.paths[i] = False

    def build_graph(self, numCourses, prerequisites):
        graph = [[] for _ in range(numCourses)]
        for edge in prerequisites:
            _from = edge[1]
            _to = edge[0]
            graph[_from].append(_to)
        return graph
