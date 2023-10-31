# author: tobebetter9527
# since: 2023/10/31 10:37
from typing import Optional

from com.dsa.leetcode.linked_list import ListNode


class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head:
            return False
        fast = head.next
        slow = head
        while fast and fast.next and fast != slow:
            fast = fast.next.next
            slow = slow.next
        return fast == slow
