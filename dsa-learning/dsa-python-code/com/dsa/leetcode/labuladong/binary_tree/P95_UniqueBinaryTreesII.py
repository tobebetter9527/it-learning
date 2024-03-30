# author: tobebetter9527
# since: 2024/3/27 8:37
from typing import Optional, List

from com.dsa.leetcode.labuladong.binary_tree import TreeNode


class Solution:
    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        return self.build(1, n)

    def build(self, left, right):
        if left > right:
            return [None, ]
        allTrees = []
        for i in range(left, right + 1):
            leftTrees = self.build(left, i - 1)
            rightTrees = self.build(i + 1, right)
            for leftTree in leftTrees:
                for rightTree in rightTrees:
                    root = TreeNode(i)
                    root.left = leftTree
                    root.right = rightTree
                    allTrees.append(root)
        return allTrees
