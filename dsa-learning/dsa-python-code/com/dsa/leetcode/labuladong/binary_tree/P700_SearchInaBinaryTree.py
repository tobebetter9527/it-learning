# author: tobebetter9527
# since: 2024/3/22 8:57
from typing import Optional

from com.dsa.leetcode.labuladong.binary_tree import TreeNode


class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if not root:
            return None
        if root.val == val:
            return root
        elif root.val > val:
            return self.searchBST(root.left, val)
        else:
            return self.searchBST(root.right, val)

    def searchBST2(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        while root:
            if root.val == val:
                return root
            root = root.left if root.val > val else root.right
        return None
