from typing import List


class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        res = []
        path = []
        self.traverse(graph, 0, path, res)
        return res

    def traverse(self, graph, idx, path, res):
        path.append(idx)
        if idx == len(graph) - 1:
            res.append(list(path))
            path.pop()
            return
        for i in graph[idx]:
            self.traverse(graph, i, path, res)
        path.pop()
