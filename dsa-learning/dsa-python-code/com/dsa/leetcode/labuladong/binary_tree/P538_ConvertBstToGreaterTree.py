# author: tobebetter9527
# since: 2024/3/20 8:30
from typing import Optional

from com.dsa.leetcode.labuladong.binary_tree import TreeNode


class Solution:
    def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        self.ans = 0
        self.in_order(root)
        return root

    def in_order(self, root):
        if not root:
            return 0
        self.in_order(root.left)
        root.val = root.val + self.ans
        self.ans = root.val
        self.in_order(root.right)
