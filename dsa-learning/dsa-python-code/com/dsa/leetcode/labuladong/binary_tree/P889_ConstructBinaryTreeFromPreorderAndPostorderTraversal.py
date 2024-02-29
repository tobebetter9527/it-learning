# author: tobebetter9527
# since: 2024/2/29 11:11
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import List, Optional

from com.dsa.leetcode.labuladong.binary_tree.TreeNode import TreeNode


class Solution:
    def __init__(self):
        self.postMap = {}

    def constructFromPrePost(self, preorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        length = len(preorder)
        for i in range(length):
            self.postMap[postorder[i]] = i
        return self.build(preorder, 0, length - 1, postorder, 0, length - 1)

    def build(self, preorder, preStart, preEnd, postorder, postStart, postEnd):
        if preStart > preEnd:
            return None
        root = TreeNode(preorder[preStart])
        if preStart == preEnd:
            return root

        leftVal = preorder[preStart + 1]
        idx = self.postMap.get(leftVal)
        length = idx - postStart
        root.left = self.build(preorder, preStart + 1, preStart + 1 + length, postorder, postStart, idx)
        root.right = self.build(preorder, preStart + 1 + length + 1, preEnd, postorder, idx + 1, postEnd - 1)
        return root
