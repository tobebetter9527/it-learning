# author: tobebetter9527
# since: 2024/4/22 18:15
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        big = max(p.val, q.val)
        small = min(p.val, q.val)
        return self.find(root, small, big)

    def find(self, root, small, big):
        if not root:
            return None
        if root.val < small:
            return self.find(root.right, small, big)
        if root.val > big:
            return self.find(root.left, small, big)
        return root
