from collections import deque
from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph, in_degrees = self.build_graph_and_in_degrees(numCourses, prerequisites)

        queue = deque()
        for i in range(numCourses):
            if in_degrees[i] == 0:
                queue.append(i)
        while queue:
            i = queue.popleft()
            numCourses -= 1
            for _to in graph[i]:
                in_degrees[_to] -= 1
                if in_degrees[_to] == 0:
                    queue.append(_to)
        return numCourses == 0

    def build_graph_and_in_degrees(self, numCourses, prerequisites):
        graph = [[] for _ in range(numCourses)]
        in_degrees = [0] * numCourses
        for edge in prerequisites:
            _to = edge[0]
            _from = edge[1]
            graph[_from].append(_to)
            in_degrees[_to] += 1
        return graph, in_degrees
