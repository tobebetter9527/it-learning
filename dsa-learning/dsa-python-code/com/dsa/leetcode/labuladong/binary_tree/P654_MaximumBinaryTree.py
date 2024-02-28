# author: tobebetter9527
# since: 2024/2/28 8:42
from typing import List, Optional

from com.dsa.leetcode.labuladong.binary_tree import TreeNode


class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> Optional[TreeNode]:
        return self.build(nums, 0, len(nums) - 1)

    def build(self, nums, left, right):
        if left > right:
            return None
        max_index, max_value = left, nums[left]
        for i in range(left + 1, right + 1):
            if max_value < nums[i]:
                max_index = i
                max_value = nums[i]
        root = TreeNode(max_value)
        root.left = self.build(nums, left, max_index - 1)
        root.right = self.build(nums, max_index + 1, right)
        return root
