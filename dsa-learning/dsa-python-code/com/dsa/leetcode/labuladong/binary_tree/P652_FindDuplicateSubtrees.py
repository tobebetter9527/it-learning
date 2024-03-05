# author: tobebetter9527
# since: 2024/3/5 8:42
from typing import Optional, List

from com.dsa.leetcode.labuladong.binary_tree import TreeNode
from collections import defaultdict


class Solution:
    def __init__(self):
        self.map = defaultdict(int)
        self.res = []

    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        self.traverse(root)
        return self.res

    def traverse(self, root):
        if not root:
            return "#"
        left = self.traverse(root.left)
        right = self.traverse(root.right)
        subtree = left + "," + right + "," + str(root.val)
        count = self.map[subtree]
        if count == 1:
            self.res.append(root)
        self.map[subtree] = count + 1
        return subtree
