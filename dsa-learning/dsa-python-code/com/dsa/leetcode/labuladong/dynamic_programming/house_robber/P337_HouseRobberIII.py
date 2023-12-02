from typing import Optional

from com.dsa.leetcode.labuladong.binary_tree import TreeNode


class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        dp = self.dp(root)
        return max(dp)

    def dp(self, root: Optional[TreeNode]):
        if not root:
            return [0,0]
        left = self.dp(root.left)
        right = self.dp(root.right)
        # not rob
        val1 = max(left[0], left[1]) + max(right[0], right[1])
        # rob
        val2 = root.val + left[0] + right[0]
        return [val1, val2]
