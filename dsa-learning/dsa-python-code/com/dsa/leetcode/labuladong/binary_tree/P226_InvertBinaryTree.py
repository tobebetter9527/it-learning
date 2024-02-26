# author: tobebetter9527
# since: 2024/2/26 15:19
from typing import Optional

from com.dsa.leetcode.labuladong.binary_tree.TreeNode import TreeNode


class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None
        left = self.invertTree(root.left)
        right = self.invertTree(root.right)
        root.right = left
        root.left = right
        return root

    def invertTree2(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        self.traverse(root)
        return root

    def traverse(self, root):
        if not root:
            return
        root.left, root.right = root.right, root.left
        self.traverse(root.left)
        self.traverse(root.right)
