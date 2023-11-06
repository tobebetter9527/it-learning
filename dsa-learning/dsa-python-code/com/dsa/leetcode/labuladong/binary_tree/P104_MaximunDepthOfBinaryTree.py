# author: tobebetter9527
# since: 2023/11/6 10:07
from typing import Optional

from com.dsa.leetcode.labuladong.binary_tree import TreeNode


class Solution:

    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        len1 = self.maxDepth(root.left)
        len2 = self.maxDepth(root.right)
        return max(len2, len1) + 1
