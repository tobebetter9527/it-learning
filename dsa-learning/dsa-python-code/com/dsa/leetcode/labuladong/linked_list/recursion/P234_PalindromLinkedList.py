# author: tobebetter9527
# since: 2023/12/8 17:10
from typing import Optional

from com.dsa.leetcode.labuladong.linked_list.ListNode import ListNode


class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        self.left = head
        return self.traverse(head)

    def traverse(self, right):
        if not right:
            return True
        res = self.traverse(right.next)
        res = res and self.left.val == right.val
        self.left = self.left.next
        return res


if __name__ == '__main__':
    node6 = ListNode(7, None)
    node5 = ListNode(6, node6)
    node4 = ListNode(5, node5)
    node3 = ListNode(4, node4)
    node2 = ListNode(3, node3)
    node1 = ListNode(2, node2)
    head = ListNode(1, node1)
    solu = Solution()
    res = solu.isPalindrome(head)
    print(res)
