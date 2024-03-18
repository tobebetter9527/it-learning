# author: tobebetter9527
# since: 2024/3/18 10:42
from typing import Optional

from com.dsa.leetcode.labuladong.binary_tree import TreeNode


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.k = k
        self.inOrder(root)
        return self.ans

    def inOrder(self, root):
        if not root:
            return
        self.inOrder(root.left)
        if self.k == 0:
            return
        self.k -= 1
        if self.k == 0:
            self.ans = root.val
        self.inOrder(root.right)
