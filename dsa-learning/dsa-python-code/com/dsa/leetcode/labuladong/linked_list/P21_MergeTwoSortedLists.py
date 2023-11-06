# author: tobebetter9527
# since: 2023/10/26 10:43
from typing import Optional

from com.dsa.leetcode.labuladong.linked_list import ListNode


class Solution:

    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        cur = dummy
        while list1 and list2:
            if list1.val >= list2.val:
                cur.next = list2
                list2 = list2.next
            else:
                cur.next = list1
                list1 = list1.next
            cur = cur.next
        cur.next = list1 if list1 is not None else list2
        return dummy.next

    def mergeTwoLists2(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1:
            return list2
        if not list2:
            return list1
        if list1.val >= list2.val:
            list2.next = self.mergeTwoLists2(list1, list2.next)
            return list2
        else:
            list1.next = self.mergeTwoLists2(list1.next, list2)
            return list1


if __name__ == '__main__':
    print("hello world")
