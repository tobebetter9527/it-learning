# author: tobebetter9527
# since: 2024/2/28 16:02
from typing import List, Optional

from com.dsa.leetcode.labuladong.binary_tree.TreeNode import TreeNode


class Solution:
    def __init__(self):
        self.inorderMap = {}

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        for i in range(len(inorder)):
            self.inorderMap[inorder[i]] = i
        return self.build(preorder, 0, len(preorder) - 1, inorder, 0, len(inorder) - 1)

    def build(self, preorder, preStart, preEnd, inorder, inStart, inEnd):
        if preStart > preEnd:
            return None

        root = TreeNode(preorder[preStart])
        idx = self.inorderMap.get(preorder[preStart])
        length = idx - inStart
        root.left = self.build(preorder, preStart + 1, preStart + length, inorder, inStart, idx - 1)
        root.right = self.build(preorder, preStart + length + 1, preEnd, inorder, idx + 1, inEnd)
        return root


if __name__ == '__main__':
    preorder = [3, 9, 20, 15, 7]
    inorder = [9, 3, 15, 20, 7]
    solu = Solution()
    print(solu.buildTree(preorder, inorder))
