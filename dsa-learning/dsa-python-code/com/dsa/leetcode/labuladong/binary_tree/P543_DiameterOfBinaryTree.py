from typing import Optional

from com.dsa.leetcode.labuladong.binary_tree import TreeNode


class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.maxDiameter = 0

        def maxDepth(node):
            if not node:
                return 0
            left = maxDepth(node.left)
            right = maxDepth(node.right)
            self.maxDiameter = max(self.maxDiameter, left + right)
            return max(left, right) + 1

        maxDepth(root)
        return self.maxDiameter
