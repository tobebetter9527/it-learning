from collections import deque
from typing import List


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph, in_degrees = self.build(numCourses, prerequisites)

        q = deque()
        for i in range(numCourses):
            if not in_degrees[i]:
                q.append(i)
        res = []
        while q:
            _from = q.popleft()
            numCourses -= 1
            res.append(_from)
            for _to in graph[_from]:
                in_degrees[_to] -= 1
                if not in_degrees[_to]:
                    q.append(_to)
        if numCourses:
            return []
        return res

    def build(self, numCourses: int, prerequisites: List[List[int]]):
        graph = [[] for _ in range(numCourses)]
        in_degrees = [0] * numCourses
        for edge in prerequisites:
            _from = edge[1]
            _to = edge[0]
            in_degrees[_to] += 1
            graph[_from].append(_to)
        return graph, in_degrees
