# author: tobebetter9527
# since: 2024/3/21 8:53
from typing import Optional

from com.dsa.leetcode.labuladong.binary_tree import TreeNode


class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self._isValidBST(root, float('-inf'), float('inf'))

    def _isValidBST(self, root, min_value, max_value):
        if not root:
            return True
        if root.val >= max_value or root.val <= min_value:
            return False
        return self._isValidBST(root.left, min_value, root.val) and self._isValidBST(root.right, root.val, max_value)
