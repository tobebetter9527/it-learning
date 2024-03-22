# author: tobebetter9527
# since: 2024/3/22 17:19
from typing import Optional

from com.dsa.leetcode.labuladong.binary_tree import TreeNode


class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if not root:
            return TreeNode(val)
        if root.val < val:
            root.right = self.insertIntoBST(root.right, val)
        else:
            root.left = self.insertIntoBST(root.left, val)
        return root

    def insertIntoBST2(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if not root:
            return TreeNode(val)
        pre, cur = root, root
        while cur:
            pre = cur
            if cur.val < val:
                cur = cur.right
            else:
                cur = cur.left
        if pre.val < val:
            pre.right = TreeNode(val)
        else:
            pre.left = TreeNode(val)
        return root
