# author: tobebetter9527
# since: 2024/4/24 8:58
from typing import Optional

from com.dsa.leetcode.labuladong.binary_tree import TreeNode


class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        left = self.countHeight(root.left)
        right = self.countHeight(root.right)
        if left == right:
            return self.countNodes(root.right) + (1 << left)
        else:
            return self.countNodes(root.left) + (1 << right)

    def countHeight(self, root):
        h = 0
        while root:
            h += 1
            root = root.left
        return h
