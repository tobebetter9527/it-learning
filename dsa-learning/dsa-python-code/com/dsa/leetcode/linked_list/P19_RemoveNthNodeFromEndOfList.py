# author: tobebetter9527
# since: 2023/10/30 18:01
from typing import Optional

from com.dsa.leetcode.linked_list.ListNode import ListNode


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        fast, slow = dummy, dummy

        while n > 0:
            fast = fast.next
            n = n - 1

        while fast.next:
            fast = fast.next
            slow = slow.next

        slow.next = slow.next.next
        return dummy.next
