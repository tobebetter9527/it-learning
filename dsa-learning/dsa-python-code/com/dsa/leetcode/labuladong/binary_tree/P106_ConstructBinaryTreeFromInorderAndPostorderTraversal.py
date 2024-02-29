# author: tobebetter9527
# since: 2024/2/29 10:06
from typing import List, Optional

from com.dsa.leetcode.labuladong.binary_tree.TreeNode import TreeNode


class Solution:
    def __init__(self):
        self.valIdxMap = {}

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        length = len(inorder)
        for i in range(length):
            self.valIdxMap[inorder[i]] = i
        return self.build(inorder, 0, length - 1, postorder, 0, length - 1)

    def build(self, inorder, inStart, inEnd, postorder, postStart, postEnd):
        if inStart > inEnd:
            return None
        root = TreeNode(postorder[postEnd])
        idx = self.valIdxMap.get(postorder[postEnd])
        length = idx - inStart
        root.left = self.build(inorder, inStart, idx - 1, postorder, postStart, postStart + length - 1)
        root.right = self.build(inorder, idx + 1, inEnd, postorder, postStart + length, postEnd - 1)
        return root
