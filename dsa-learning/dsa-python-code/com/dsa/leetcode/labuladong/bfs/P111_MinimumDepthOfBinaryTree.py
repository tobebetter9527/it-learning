import queue
from typing import Optional

from com.dsa.leetcode.labuladong.bfs import TreeNode


class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        q = queue.Queue()
        q.put(root)
        minDepth = 0
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                node = q.get()
                if not node.left and not node.right:
                    return minDepth + 1
                if node.left:
                    q.put(node.left)
                if node.right:
                    q.put(node.right)
            minDepth += 1
        return minDepth
