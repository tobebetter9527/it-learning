from typing import Optional

from com.dsa.leetcode.labuladong.linked_list import ListNode


class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        newDummy = ListNode()
        newCur = newDummy

        oldDummy = ListNode()
        oldCur = oldDummy

        while head:
            if head.val >= x:
                oldCur.next = head
                oldCur = head
            else:
                newCur.next = head
                newCur = head
            head = head.next
        oldCur.next = None
        newCur.next = oldDummy.next
        return newDummy.next
