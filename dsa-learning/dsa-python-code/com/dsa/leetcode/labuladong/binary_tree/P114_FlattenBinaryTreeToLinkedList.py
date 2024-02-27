# author: tobebetter9527
# since: 2024/2/27 15:54
from typing import Optional

from com.dsa.leetcode.labuladong.binary_tree import TreeNode


class Solution:
    def __init__(self):
        self.pre = None

    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        self.flatten(root.right)
        self.flatten(root.left)
        root.right = self.pre
        root.left = None
        self.pre = root