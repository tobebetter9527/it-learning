from typing import Optional

from com.dsa.leetcode.labuladong.linked_list.ListNode import ListNode


class Solution:
    def __init__(self):
        self.successor = None

    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if left == 1:
            return self.reverseN(head, right)
        head.next = self.reverseBetween(head.next, left - 1, right - 1)
        return head

    def reverseN(self, head, n):
        if n == 1:
            self.successor = head.next
            return head
        newHead = self.reverseN(head.next, n - 1)
        head.next.next = head
        head.next = self.successor
        return newHead
