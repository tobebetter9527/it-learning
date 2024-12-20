import random
from typing import Optional

from com.dsa.leetcode.labuladong.linked_list import ListNode


class Solution:

    def __init__(self, head: Optional[ListNode]):
        self.head = head

    def getRandom(self) -> int:
        i, res = 1, 0
        cur = self.head
        while cur:
            if random.randrange(i) == 0:
                res = cur.val
            i += 1
            cur = cur.next
        return res
