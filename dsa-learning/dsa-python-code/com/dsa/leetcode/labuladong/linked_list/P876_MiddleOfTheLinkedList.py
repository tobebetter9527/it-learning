# author: tobebetter9527
# since: 2023/10/31 9:10
from typing import Optional

from com.dsa.leetcode.labuladong.linked_list import ListNode


class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        fast, slow = head, head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        return slow
